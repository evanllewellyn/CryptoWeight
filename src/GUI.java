import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by evanllewellyn on 8/20/15.
 */



public class GUI extends Application {

        ListView<String> dataDisplay;
        SaveInfo loadedData;

        public void start(Stage primaryStage) {

            //Creating FileStore object and using it load in a SaveInfo object that was saved last API call.
            FileStore fs = new FileStore();
            loadedData = fs.readPrices();


            primaryStage.setTitle("CryptoWeight");

            //Creating borderPane layout type.
            BorderPane borderPane = new BorderPane();

            //VBox that all the components will be put into eventually
            VBox vbox = new VBox();

            //HBox for top components
            HBox topHbox = new HBox();
            topHbox.setSpacing(40);
            topHbox.setAlignment(Pos.TOP_RIGHT);

            //Label for top section
            Label topLabel = new Label("Bitcoin Weighted Prices");
            topLabel.setMaxWidth(300);
            topLabel.setAlignment(Pos.CENTER);

            /*
             * Creating button for description about weighted prices. On action the button launches an InfoBox popup
             * window that contains a description of the concept.
             */
            Button aboutButton = new Button("What are weighted prices?");
            aboutButton.setOnAction(event -> {
                String sum = new Character((char) 931).toString();
                InfoBox.infoB("About Weighted Prices", " Weighted Prices is the sum of all dollars traded for each " +
                        " transaction \ndivided by the total number of transactions for the given time period. \n\n" +
                        " Weighted Price = " + sum + " (Number of Bitcoins bought x Price of Bitcoin) / Total Bitcoins bought" +
                        "\n\n\nWeighted Prices yield lower fluctuations than using the single markets latest price." +
                        "\nThis application displays the Average Weighted Prices over three intervals for many different" +
                        "\ncurrencies around the world.");
            });

            //Adding label/description button to top Hbox.
            topHbox.getChildren().addAll(topLabel, aboutButton);

            //Hbox for ChoiceBox and Display button.
            HBox choiceHB = new HBox();


            //Creating and filling ChoiceBox with all of the different currencies that can be viewed.
            ChoiceBox<String> cb = new ChoiceBox<>();
            cb.getItems().addAll("US Dollar, USD", "Indonesian Rupiah, IDR", "Israeli New Sheqel, ILS", "British Pound, GBP", "Danish Krone, DKK", "Canadian Dollar, CAD",
                    "Japanese Yen, JPY", "Swedish Krona, SEK", "Sudanese Pound, SDG", "Hong Kong Dollar, HKD", "Australian Dollar, AUS", "Swiss Franc, CHF", "Chinese Yuan, CNY",
                    "Bitcoin, LTC", "New Zealand Dollar, NZD", "Thai Baht, THB", "Euro, EUR", "Argentine Peso, ARS", "Russian Ruble, RUB", "Indian Rupee, INR", "Mexican Peso, MXN",
                    "Brazilian Real, BRL", "Namecoin, NMC", "South African Rand, ZAR");
            cb.setValue("US Dollar, USD");


            /*
             * Creating button to display prices. On action the button checks if there loaded data. If there is
             * it takes the string from the current selection in the ChoiceBox and passes it into valsByCur() method
             * in the Bitcoinprice class. Then displays the returned results in the ListView below. If no data
             *  is loaded launches an InfoBox popup window describing no data.
             */
            Button cbButton = new Button("Display Weighted Price");
            cbButton.setOnAction(event -> {
                if (loadedData != null) {
                    dataDisplay.getItems().clear();
                    String s = getChoice(cb);

                    String[] results = Bitcoinprice.valsByCur(s, loadedData.curBit);

                    dataDisplay.getItems().addAll(results[0] + " as of " + loadedData.timeSaved.
                            format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)), results[1], results[2], results[3]);
                } else {
                    InfoBox.infoB("No Data", "No price data has been loaded. Cannot retrieve weighted price. \n " +
                            "Data can be loaded with Update Prices below.");
                }

            });

            //Adding components to HBox for choices
            choiceHB.setSpacing(5);
            choiceHB.getChildren().addAll(cb, cbButton);
            choiceHB.setAlignment(Pos.CENTER);


            // Creating ListView that will display prices for the application.
            dataDisplay = new ListView<>();
            dataDisplay.setMaxHeight(100);
            dataDisplay.setMinHeight(100);

            //Creating Hbox for ApiButton and label.
            HBox apiHbox = new HBox();
            apiHbox.setSpacing(100);
            apiHbox.setAlignment(Pos.CENTER);

            Label apiLabel = new Label();

            /*
              *Creating button to call api. On action the button launches a ConfirmBox popup to check with user. If
             * the popup returns true, Creates string for the json api data retrieved from getData(). Uses
              *  processData() to make a CurBit object with the data from the API call. Creates a SaveInfo object
              *  that contains the new CurBit and the LocalDateTime of when it was created. Uses FileStores savePrices()
              *  method to save the new SaveInfo object to a data.txt file. Adjusts the apiLabel's text to current time
              *
              */

            Button apiButton = new Button("Update Weighted Prices");
            apiButton.setMaxWidth(300);
            apiButton.setOnAction(event -> {

                boolean confirm = ConfirmBox.confirm("Update Prices", "Are you sure you want to update the price?\nIt " +
                        "is advised to wait at least 15 minutes between updates.");

                if (confirm) {
                    String apiData = Bitcoinprice.getData();
                    CurBit updatedData = Bitcoinprice.processData(apiData);
                    loadedData = new SaveInfo(updatedData);
                    fs.savePrices(loadedData);
                    apiLabel.setText("Last updated: " + loadedData.timeSaved.format(DateTimeFormatter.
                            ofLocalizedDateTime(FormatStyle.MEDIUM)));
                    dataDisplay.getItems().clear();
                    dataDisplay.getItems().add("Data has been updated.");
                }
            });

            //Adding button to apiHBox
            apiHbox.getChildren().addAll(apiButton);

            //Prints the appropriate messages to the apiLabel and ListView based on if data was loaded on startup.
            if(loadedData != null) {
                dataDisplay.getItems().add("Data successfully loaded from file.");
                apiLabel.setText("Last updated: " +loadedData.timeSaved.format(DateTimeFormatter.
                        ofLocalizedDateTime(FormatStyle.MEDIUM)));
            } else {
                dataDisplay.getItems().add("Data not loaded from file, must updated below.");
                apiLabel.setText("Has not been updated.");
            }

            //Hbox timebox will contain the apiLabel.
            HBox timebox = new HBox();
            timebox.getChildren().add(apiLabel);
            timebox.setAlignment(Pos.TOP_RIGHT);


            //Adding all the HBoxes and their components to the Vbox.
            vbox.setSpacing(20);
            vbox.getChildren().addAll(topHbox, choiceHB, dataDisplay, apiHbox, timebox);

            //Adding the Vbox to the borderPane layout
            borderPane.setCenter(vbox);

            //Creating a Scene with the borderPane layout and adding the CSS styling to it.
            Scene scene = new Scene(borderPane, 700, 300);
            scene.getStylesheets().add("GUIDesign.css");

            //Adding the scene to the stage and setting its fixed sizes.
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(700);
            primaryStage.setMaxWidth(700);
            primaryStage.setMinHeight(350);
            primaryStage.setMaxHeight(350);
            primaryStage.show();

        }

        // getChoice() retrieves the string that on the ChoiceBox's selected value.
        public String getChoice(ChoiceBox<String> cb) {
            String choice = cb.getValue();

            return choice;
        }


        public static void main(String[] args) {
            launch(args);
        }

}

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by evanllewellyn on 8/19/15. Bitcoinprice contains methods used to get/process/display information
 * retrieved from Bitcoinchart's API. Data supplied by http://bitcoincharts.com/
 */
public class Bitcoinprice {


    /*
     * getData() retrieves the Json object containing the price data from bitcoinchart's public api
     * Returns the json object in a string form.
     */

    public static String getData() {
        BufferedReader reader = null;
        try {
            URL url = new URL("http://api.bitcoincharts.com/v1/weighted_prices.json");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer str = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                str.append(chars, 0, read);

            return str.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "didnt work";
    }


    /*
     * processData() uses Google's gson API to parse the string form of the Json object.
     * returns a CurBit object that is used to collect the data from the Json object.
     */
    public static CurBit processData(String data) {
        Gson gson = new Gson();
        CurBit info = gson.fromJson(data, CurBit.class);

        return info;

    }


    /*
     * valsByCur() returns an array of the data corresponding the the currency within the curType parameter.
     * The data returned from this is printed to the ListView in the GUI.
     */
    public static String[] valsByCur(String curType, CurBit cb) {
        String[] data = new String[4];

        //Parsing the line of data to retrieve the currency type.
        String [] split = curType.split(", ");

        data[0] = curType;

        /*
         * This switch statement matches the parsed currency string with its corresponding currency information
         * field in the CurBit object. Unfortunately the statement had to be this long because the gson api requires a
         * separate field/getter/setter in the CurBit object for each language.
         */
        switch(split[1]) {
            case "USD": data[1] = "24 Hours: "+ cb.getUSD().get("24h");
                        data[2] = "7 Days: "+ cb.getUSD().get("7d");
                        data[3] = "30 Days: "+ cb.getUSD().get("30d");
                        break;

            case "IDR": data[1] = "24 Hours: "+ cb.getIDR().get("24h");
                        data[2] = "7 Days: "+ cb.getIDR().get("7d");
                        data[3] = "30 Days: "+ cb.getIDR().get("30d");
                        break;

            case "ILS": data[1] = "24 Hours: "+ cb.getILS().get("24h");
                        data[2] = "7 Days: "+ cb.getILS().get("7d");
                        data[3] = "30 Days: "+ cb.getILS().get("30d");
                        break;

            case "GBP": data[1] = "24 Hours: "+ cb.getGBP().get("24h");
                        data[2] = "7 Days: "+ cb.getGBP().get("7d");
                        data[3] = "30 Days: "+ cb.getGBP().get("30d");
                        break;

            case "DKK": data[1] = "24 Hours: "+ cb.getDKK().get("24h");
                        data[2] = "7 Days: "+ cb.getDKK().get("7d");
                        data[3] = "30 Days: "+ cb.getDKK().get("30d");
                        break;

            case "CAD": data[1] = "24 Hours: "+ cb.getCAD().get("24h");
                        data[2] = "7 Days: "+ cb.getCAD().get("7d");
                        data[3] = "30 Days: "+ cb.getCAD().get("30d");
                        break;

            case "JPY": data[1] = "24 Hours: "+ cb.getJPY().get("24h");
                        data[2] = "7 Days: "+ cb.getJPY().get("7d");
                        data[3] = "30 Days: "+ cb.getJPY().get("30d");
                        break;

            case "XRP": data[1] = "24 Hours: "+ cb.getXRP().get("24h");
                        data[2] = "7 Days: "+ cb.getXRP().get("7d");
                        data[3] = "30 Days: "+ cb.getXRP().get("30d");
                        break;

            case "SEK": data[1] = "24 Hours: "+ cb.getSEK().get("24h");
                        data[2] = "7 Days: "+ cb.getSEK().get("7d");
                        data[3] = "30 Days: "+ cb.getSEK().get("30d");
                        break;

            case "SGD": data[1] = "24 Hours: "+ cb.getSGD().get("24h");
                        data[2] = "7 Days: "+ cb.getSGD().get("7d");
                        data[3] = "30 Days: "+ cb.getSGD().get("30d");
                        break;

            case "HKD": data[1] = "24 Hours: "+ cb.getHKD().get("24h");
                        data[2] = "7 Days: "+ cb.getHKD().get("7d");
                        data[3] = "30 Days: "+ cb.getHKD().get("30d");
                        break;

            case "AUD": data[1] = "24 Hours: "+ cb.getAUD().get("24h");
                        data[2] = "7 Days: "+ cb.getAUD().get("7d");
                        data[3] = "30 Days: "+ cb.getAUD().get("30d");
                        break;

            case "CHF": data[1] = "24 Hours: "+ cb.getCHF().get("24h");
                        data[2] = "7 Days: "+ cb.getCHF().get("7d");
                        data[3] = "30 Days: "+ cb.getCHF().get("30d");
                        break;

            case "CNY": data[1] = "24 Hours: "+ cb.getCNY().get("24h");
                        data[2] = "7 Days: "+ cb.getCNY().get("7d");
                        data[3] = "30 Days: "+ cb.getCNY().get("30d");
                        break;

            case "LTC": data[1] = "24 Hours: "+ cb.getLTC().get("24h");
                        data[2] = "7 Days: "+ cb.getLTC().get("7d");
                        data[3] = "30 Days: "+ cb.getLTC().get("30d");
                        break;

            case "NZD": data[1] = "24 Hours: "+ cb.getNZD().get("24h");
                        data[2] = "7 Days: "+ cb.getNZD().get("7d");
                        data[3] = "30 Days: "+ cb.getNZD().get("30d");
                        break;

            case "THB": data[1] = "24 Hours: "+ cb.getTHB().get("24h");
                        data[2] = "7 Days: "+ cb.getTHB().get("7d");
                        data[3] = "30 Days: "+ cb.getTHB().get("30d");
                        break;

            case "EUR": data[1] = "24 Hours: "+ cb.getEUR().get("24h");
                        data[2] = "7 Days: "+ cb.getEUR().get("7d");
                        data[3] = "30 Days: "+ cb.getEUR().get("30d");
                        break;

            case "ARS": data[1] = "24 Hours: "+ cb.getARS().get("24h");
                        data[2] = "7 Days: "+ cb.getARS().get("7d");
                        data[3] = "30 Days: "+ cb.getARS().get("30d");
                        break;

            case "NOK": data[1] = "24 Hours: "+ cb.getNOK().get("24h");
                        data[2] = "7 Days: "+ cb.getNOK().get("7d");
                        data[3] = "30 Days: "+ cb.getNOK().get("30d");
                        break;

            case "RUB": data[1] = "24 Hours: "+ cb.getRUB().get("24h");
                        data[2] = "7 Days: "+ cb.getRUB().get("7d");
                        data[3] = "30 Days: "+ cb.getRUB().get("30d");
                        break;

            case "INR": data[1] = "24 Hours: "+ cb.getINR().get("24h");
                        data[2] = "7 Days: "+ cb.getINR().get("7d");
                        data[3] = "30 Days: "+ cb.getINR().get("30d");
                        break;

            case "MXN": data[1] = "24 Hours: "+ cb.getMXN().get("24h");
                        data[2] = "7 Days: "+ cb.getMXN().get("7d");
                        data[3] = "30 Days: "+ cb.getMXN().get("30d");
                        break;

            case "CZK": data[1] = "24 Hours: "+ cb.getCZK().get("24h");
                        data[2] = "7 Days: "+ cb.getCZK().get("7d");
                        data[3] = "30 Days: "+ cb.getCZK().get("30d");
                        break;

            case "BRL": data[1] = "24 Hours: "+ cb.getBRL().get("24h");
                        data[2] = "7 Days: "+ cb.getBRL().get("7d");
                        data[3] = "30 Days: "+ cb.getBRL().get("30d");
                        break;

            case "NMC": data[1] = "24 Hours: "+ cb.getNMC().get("24h");
                        data[2] = "7 Days: "+ cb.getNMC().get("7d");
                        data[3] = "30 Days: "+ cb.getNMC().get("30d");
                        break;

            case "PLN": data[1] = "24 Hours: "+ cb.getPLN().get("24h");
                        data[2] = "7 Days: "+ cb.getPLN().get("7d");
                        data[3] = "30 Days: "+ cb.getPLN().get("30d");
                        break;

            case "ZAR": data[1] = "24 Hours: "+ cb.getZAR().get("24h");
                        data[2] = "7 Days: "+ cb.getZAR().get("7d");
                        data[3] = "30 Days: "+ cb.getZAR().get("30d");
                        break;

        }


    /*
     * If no trading occurred in any time period the API sets the value to null. Checks any element of data is null
     *  and appropriately changes it for display on the GUI.
     */
        if( data[1] == null)
            data[1] = "24 Hours: No trading during this interval.";

        if( data[2] == null)
            data[2] = "7 Days: No trading during this interval.";

        if( data[3] == null)
            data[3] = "30 Days: No trading during this interval.";


        return data;

    }

}

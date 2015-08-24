
import java.io.*;

/**
 * Created by evanllewellyn on 8/21/15. fileStore uses object io to save and read a SaveInfo object
 * so that the Weighted Prices are saved in between application uses. This prevents frequent API calls
 * to Bitcoinchart's API. Data supplied by http://bitcoincharts.com/.
 */
public class FileStore {


        /*
         * Opens the output stream and writes the current SaveInfo object. In the finally block
         * closes the stream if it has been opened.
         */
        public void savePrices(SaveInfo si) {
                OutputStream outputStream = null;
                ObjectOutputStream objectOutputStream = null;

                try {
                        outputStream = new FileOutputStream("data.txt");
                        objectOutputStream = new ObjectOutputStream(outputStream);
                        objectOutputStream.writeObject(si);
                        objectOutputStream.flush();

                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (outputStream != null) {
                                        outputStream.close();
                                }
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }


        }

        /*
        * Opens the input stream and reads and casts the object to a FileInfo. In the finally block
        * closes the stream if it has been opened. If it returns a FileNotFoundException
        * it indicates no data has been previously saved does nothing, keeping SaveInfo si null.
        * When the app is started, if the initial SaveInfo object is null, prints that there is
        * no data stored.
        */


        public SaveInfo readPrices() {
                SaveInfo si = null;
                InputStream inputStream = null;
                ObjectInputStream objectInputStream = null;

                try {
                        inputStream = new FileInputStream("data.txt");
                        objectInputStream = new ObjectInputStream(inputStream);
                        si = (SaveInfo) objectInputStream.readObject();

                } catch (FileNotFoundException e) {

                } catch (IOException e) {
                        e.printStackTrace();
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (inputStream != null) {
                                        inputStream.close();
                                }
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }

                return si;
        }

}

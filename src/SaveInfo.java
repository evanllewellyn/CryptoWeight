import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Created by evanllewellyn on 8/21/15.The SaveInfo class contains the CurBit object that contains the info
 * retrieved from the Json object from Bitcoincharts API. It also has a LocalDateTime field that is
 * updated when a new object is created. This allows the application to keep track of the last time the
 * API was called and data was updated. Data supplied by http://bitcoincharts.com/.
 */


public class SaveInfo implements Serializable {
    CurBit curBit;
    LocalDateTime timeSaved;

    public SaveInfo(CurBit cb) {
        curBit = cb;
        timeSaved = LocalDateTime.now();

    }


}

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by evanllewellyn on 8/20/15. The Class that will be used when calling Google's gson API. The class
 * is designed to have a field/setter/getter for every field that is on the Json object retrieved with
 * Bitcoinchart's API. Each variable represents a different currency. Each currency has a HashMap<String, String>
 *   that contains the prices for 24h, 7d, and 24d timeperiods. Data supplied by http://bitcoincharts.com/.
 */

public class CurBit implements Serializable{
    private HashMap<String, String> USD;
    private HashMap<String, String> IDR;
    private HashMap<String, String> ILS;
    private HashMap<String, String> GBP;
    private HashMap<String, String> DKK;
    private HashMap<String, String> CAD;
    private HashMap<String, String> JPY;
    private HashMap<String, String> XRP;
    private HashMap<String, String> SEK;
    private HashMap<String, String> SGD;
    private HashMap<String, String> HKD;
    private HashMap<String, String> AUD;
    private HashMap<String, String> CHF;

    public HashMap<String, String> getBRL() {
        return BRL;
    }

    public void setBRL(HashMap<String, String> BRL) {
        this.BRL = BRL;
    }

    public HashMap<String, String> getNMC() {
        return NMC;
    }

    public void setNMC(HashMap<String, String> NMC) {
        this.NMC = NMC;
    }

    public HashMap<String, String> getZAR() {
        return ZAR;
    }

    public void setZAR(HashMap<String, String> ZAR) {
        this.ZAR = ZAR;
    }

    public HashMap<String, String> getPLN() {
        return PLN;
    }

    public void setPLN(HashMap<String, String> PLN) {
        this.PLN = PLN;
    }

    private int timestamp;
    private HashMap<String, String> CNY;
    private HashMap<String, String> LTC;
    private HashMap<String, String> NZD;
    private HashMap<String, String> THB;
    private HashMap<String, String> EUR;
    private HashMap<String, String> ARS;
    private HashMap<String, String> NOK;
    private HashMap<String, String> RUB;
    private HashMap<String, String> INR;
    private HashMap<String, String> MXN;
    private HashMap<String, String> CZK;
    private HashMap<String, String> BRL;
    private HashMap<String, String> NMC;
    private HashMap<String, String> PLN;
    private HashMap<String, String> ZAR;

    public HashMap<String, String> getUSD() {
        return USD;
    }

    public void setUSD(HashMap<String, String> USD) {
        this.USD = USD;
    }

    public HashMap<String, String> getIDR() {
        return IDR;
    }

    public void setIDR(HashMap<String, String> IDR) {
        this.IDR = IDR;
    }

    public HashMap<String, String> getSEK() {
        return SEK;
    }

    public void setSEK(HashMap<String, String> SEK) {
        this.SEK = SEK;
    }

    public HashMap<String, String> getXRP() {
        return XRP;
    }

    public void setXRP(HashMap<String, String> XRP) {
        this.XRP = XRP;
    }

    public HashMap<String, String> getILS() {
        return ILS;
    }

    public void setILS(HashMap<String, String> ILS) {
        this.ILS = ILS;
    }

    public HashMap<String, String> getGBP() {
        return GBP;
    }

    public void setGBP(HashMap<String, String> GBP) {
        this.GBP = GBP;
    }

    public HashMap<String, String> getDKK() {
        return DKK;
    }

    public void setDKK(HashMap<String, String> DKK) {
        this.DKK = DKK;
    }

    public HashMap<String, String> getCAD() {
        return CAD;
    }

    public void setCAD(HashMap<String, String> CAD) {
        this.CAD = CAD;
    }

    public HashMap<String, String> getJPY() {
        return JPY;
    }

    public void setJPY(HashMap<String, String> JPY) {
        this.JPY = JPY;
    }

    public HashMap<String, String> getSGD() {
        return SGD;
    }

    public void setSGD(HashMap<String, String> SGD) {
        this.SGD = SGD;
    }

    public HashMap<String, String> getHKD() {
        return HKD;
    }

    public void setHKD(HashMap<String, String> HKD) {
        this.HKD = HKD;
    }

    public HashMap<String, String> getAUD() {
        return AUD;
    }

    public void setAUD(HashMap<String, String> AUD) {
        this.AUD = AUD;
    }

    public HashMap<String, String> getCHF() {
        return CHF;
    }

    public void setCHF(HashMap<String, String> CHF) {
        this.CHF = CHF;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public HashMap<String, String> getCNY() {
        return CNY;
    }

    public void setCNY(HashMap<String, String> CNY) {
        this.CNY = CNY;
    }

    public HashMap<String, String> getLTC() {
        return LTC;
    }

    public void setLTC(HashMap<String, String> LTC) {
        this.LTC = LTC;
    }

    public HashMap<String, String> getNZD() {
        return NZD;
    }

    public void setNZD(HashMap<String, String> NZD) {
        this.NZD = NZD;
    }

    public HashMap<String, String> getTHB() {
        return THB;
    }

    public void setTHB(HashMap<String, String> THB) {
        this.THB = THB;
    }

    public HashMap<String, String> getEUR() {
        return EUR;
    }

    public void setEUR(HashMap<String, String> EUR) {
        this.EUR = EUR;
    }

    public HashMap<String, String> getARS() {
        return ARS;
    }

    public void setARS(HashMap<String, String> ARS) {
        this.ARS = ARS;
    }

    public HashMap<String, String> getNOK() {
        return NOK;
    }

    public void setNOK(HashMap<String, String> NOK) {
        this.NOK = NOK;
    }

    public HashMap<String, String> getRUB() {
        return RUB;
    }

    public void setRUB(HashMap<String, String> RUB) {
        this.RUB = RUB;
    }

    public HashMap<String, String> getINR() {
        return INR;
    }

    public void setINR(HashMap<String, String> INR) {
        this.INR = INR;
    }

    public HashMap<String, String> getMXN() {
        return MXN;
    }

    public void setMXN(HashMap<String, String> MXN) {
        this.MXN = MXN;
    }

    public HashMap<String, String> getCZK() {
        return CZK;
    }

    public void setCZK(HashMap<String, String> CZK) {
        this.CZK = CZK;
    }
}

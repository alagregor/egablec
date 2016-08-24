package hr.foi.alagregor.filter_module;

/**
 * Created by Alan on 22/06/16.
 */
public class DataHandler {
    private String sifra;
    private String gablec_title;
    private String gablec_desc;
    private String gablec_price;
    private String restaurant_title;
    private String restaurant_adress;
    private String restaurant_phone;
    private String mail;
    private int image;

    public DataHandler(String sifra, String gablec_title, String gablec_desc, String gablec_price, String restaurant_title, String restaurant_adress, String restaurant_phone, String mail, int image ) {
        this.sifra = sifra;
        this.gablec_title = gablec_title;
        this.gablec_desc = gablec_desc;
        this.gablec_price = gablec_price;
        this.restaurant_title = restaurant_title;
        this.restaurant_adress = restaurant_adress;
        this.restaurant_phone = restaurant_phone;
        this.mail = mail;
        this.image = image;
    }

    public String getSifra() {
        return this.sifra;
    }

    public String getGablecTitle() {
        return this.gablec_title;
    }

    public String getGablecDesc() {
        return this.gablec_desc;
    }

    public String getGablecPrice() {
        return this.gablec_price;
    }

    public String getRestaurantTitle() { return this.restaurant_title; }

    public String getRestaurantAdress() { return this.restaurant_adress; }

    public String getRestaurantPhone() { return this.restaurant_phone; }

    public String getMail() { return this.mail; }

    public int getImage() {
        return this.image;
    }

}

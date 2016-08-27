package hr.foi.alagregor.egablec.data;

/**
 * Created by Alan on 27/08/16.
 */
public class Gableci implements Gablec{

    private String date;
    private String sifra;
    private String gablec_title;
    private String gablec_desc;
    private String gablec_price;
    private String restaurant_title;
    private String restaurant_adress;
    private String restaurant_phone;
    private String mail;
    private int image;
    private String url;

    public Gableci(String date, String sifra, String gablec_title, String gablec_desc, String gablec_price, String restaurant_title, String restaurant_adress, String restaurant_phone, String mail, int image ) {
        this.date = date;
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

    @Override
    public String getData(String url) {
        return this.url;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public String getSifra() {
        return this.sifra;
    }

    @Override
    public String getGablecTitle() {
        return this.gablec_title;
    }

    @Override
    public String getGablecDesc() {
        return this.gablec_desc;
    }

    @Override
    public String getGablecPrice() {
        return this.gablec_price;
    }

    @Override
    public String getRestaurantTitle() {
        return this.restaurant_title;
    }

    @Override
    public String getRestaurantAdress() {
        return this.restaurant_adress;
    }

    @Override
    public String getRestaurantPhone() {
        return this.restaurant_phone;
    }

    @Override
    public String getMail() {
        return this.mail;
    }

    @Override
    public Integer getImage() {
        return this.image;
    }
}

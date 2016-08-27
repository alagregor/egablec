package hr.foi.alagregor.egablec.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Alan on 15/08/16.
 */
public class DetailedJsonParser implements DataSource {
    //example: http://dev.srle.net/air/JSON/gableci.json"
    private String url = "";

    public DetailedJsonParser(String url) {
        this.url = url;
    }

    @Override
    public ArrayList getJSONdata(ArrayList arraylist) {
        try {
            JSONArray gableci = null;
            //URL to get JSON Array

            JSONObject json = JsonUtil.getDataFromHttpRequest(this.url);

            //JSON Node Names

            final String TAG_RESULT = "result";
            final String TAG_GABLEC_TITLE = "gablec_title";
            final String TAG_GABLEC_ID = "id";
            final String TAG_GABLEC_DESC = "gablec_desc";
            final String TAG_GABLEC_PRICE = "gablec_price";
            final String TAG_GABLEC_RESTAURANT_TITLE = "restaurant_title";
            final String TAG_GABLEC_RESTAURANT_ADRESS = "restaurant_adress";
            final String TAG_GABLEC_RESTAURANT_PHONE = "restaurant_phone";
            final String TAG_MAIL = "mail";
            final String TAG_DATE = "gablec_date";
            //final String TAG_IMAGE = "image";
            // Getting JSON Array
            gableci = json.getJSONArray(TAG_RESULT);

            if (gableci.length() > 0 && gableci != null) {
                for (int i = 0; i<gableci.length(); i++) {
                    JSONObject c = gableci.getJSONObject(i);

                    String[] sifra = new String[gableci.length()];
                    String[] gablec_title = new String[gableci.length()];
                    String[] gablec_desc = new String[gableci.length()];
                    String[] gablec_price = new String[gableci.length()];
                    String[] restaurant_title = new String[gableci.length()];
                    String[] restaurant_adress = new String[gableci.length()];
                    String[] restaurant_phone = new String[gableci.length()];
                    String[] mail = new String[gableci.length()];
                    String[] date = new String[gableci.length()];
                    int[] image = new DataHolder().DataImage();

                    for (int j = 0; j < gableci.length(); j++) {
                        date[j] = c.getString(TAG_DATE);
                        sifra[j] = c.getString(TAG_GABLEC_ID);
                        gablec_title[j] = c.getString(TAG_GABLEC_TITLE);
                        gablec_desc[j] = c.getString(TAG_GABLEC_DESC);
                        gablec_price[j] = c.getString(TAG_GABLEC_PRICE);
                        restaurant_title[j] = c.getString(TAG_GABLEC_RESTAURANT_TITLE);
                        restaurant_adress[j] = c.getString(TAG_GABLEC_RESTAURANT_ADRESS);
                        restaurant_phone[j] = c.getString(TAG_GABLEC_RESTAURANT_PHONE);
                        mail[j] = c.getString(TAG_MAIL);
                        //image[j] = c.getString(TAG_IMAGE);
                    }

                    Gableci ds = new Gableci(date[i], sifra[i], gablec_title[i], gablec_desc[i], gablec_price[i], restaurant_title[i], restaurant_adress[i], restaurant_phone[i], mail[i], image[i]);

                    arraylist.add(ds);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arraylist;
    }
}

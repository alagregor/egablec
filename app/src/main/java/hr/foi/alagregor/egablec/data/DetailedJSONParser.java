package hr.foi.alagregor.egablec.data;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Alan on 15/08/16.
 */
public class DetailedJSONParser {
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    Gableci ds;

    public static JSONObject getJSONFromUrl(String url) {

        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;

    }

    public ArrayList getJSONdata(ArrayList arraylist) {
        try {
            JSONArray gableci = null;
            //URL to get JSON Array

            String json_url = "http://dev.srle.net/air/JSON/gableci.json";

            JSONObject json = this.getJSONFromUrl(json_url);

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

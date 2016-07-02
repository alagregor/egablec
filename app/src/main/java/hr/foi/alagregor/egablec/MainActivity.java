package hr.foi.alagregor.egablec;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String gablec_date;
    String[] sifra;
    String[] gablec_title;
    String[] gablec_desc;
    String[] gablec_price;
    String[] restaurant_title;
    String[] restaurant_adress;
    String[] restaurant_phone;
    String[] mail;

    int[] image;
    ArrayList<ItemAttributes> arraylist = new ArrayList<ItemAttributes>();

    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        //get current date
        gablec_date = new SimpleDateFormat("dd.MM.yyyy.").format(new Date());
        TextView gablecDate = (TextView) findViewById(R.id.gablec_date);
        gablecDate.setText(gablec_date); //leave this line to assign a specific text

        // Generate sample data
        sifra = new String[]{"790", "812", "3", "4", "5", "6", "7", "8", "9", "10"};

        gablec_title = new String[]{
                "Grah varivo"
                ,"Pohane punjene palačinke"
                ,"Pileći file"
                ,"File oslića na bečki"
                ,"Bečki gablec pileći"
                ,"Tjestenina sa šunkom i gljivama"
                ,"Samoborski gablec"
                ,"Piletina s curryem"
                ,"Pohani batak zabatak"
                ,"Pohane lignje"
        };

        gablec_desc = new String[]{
                "sa kobasicom, m. pecivo"
                ,"sa šunkom i sirom, tartar"
                ,"u umaku od šamp., žličnjaci"
                ,"sa krumpir salatom"
                ,"pileći file 120g, rizi - bizi"
                ,"široki rezanci, šunka, gljive, vrhnje, parmezan"
                ,"150g sv. kotlet, češnjak, vino, ploške krumpira, m. pecivo"
                ,"krumpir s povrćem"
                ,"pirjane mahune"
                ,"pomfrit"
        };

        gablec_price = new String[]{"23kn", "23kn", "26kn", "25kn", "25kn", "24kn", "25kn", "24kn", "22kn", "30,50kn"};

        restaurant_title = new String[]{
                "Santa Maria"
                ,"Santa Maria"
                ,"Bistro Kula"
                ,"Bistro Kula"
                ,"Santa Maria"
                ,"Santa Maria"
                ,"Santa Maria"
                ,"Restoran Barok"
                ,"Restoran Barok"
                ,"Restoran Barok"
        };

        restaurant_adress = new String[]{
                "Optujska72F, 42000 Varaždin"
                ,"Optujska72F, 42000 Varaždin"
                ,"Trg bana Jelačića 3, 42000 Varaždin"
                ,"Trg bana Jelačića 3, 42000 Varaždin"
                ,"Optujska72F, 42000 Varaždin"
                ,"Optujska72F, 42000 Varaždin"
                ,"Optujska72F, 42000 Varaždin"
                ,"Gospodarska 3, 42000 Varaždin"
                ,"Gospodarska 3, 42000 Varaždin"
                ,"Gospodarska 3, 42000 Varaždin"
        };

        restaurant_phone = new String[]{
                "+385 (0) 42 330 000"
                ,"+385 (0) 42 330 000"
                ,"+385 (0) 42 639 212"
                ,"+385 (0) 42 639 212"
                ,"+385 (0) 42 330 000"
                ,"+385 (0) 42 330 000"
                ,"+385 (0) 42 330 000"
                ,"+385 (0) 42 658 860"
                ,"+385 (0) 42 658 860"
                ,"+385 (0) 42 658 860"
        };

        mail = new String[]{
                "test0001@test0001.com"
                ,"test0001@test0001.com"
                ,"test0002@test0002.com"
                ,"test0002@test0002.com"
                ,"test0001@test0001.com"
                ,"test0001@test0001.com"
                ,"test0001@test0001.com"
                ,"test0003@test0003.com"
                ,"test0003@test0003.com"
                ,"test0003@test0003.com"
        };

        image = new int[]{R.drawable.grah_varivo_img_0155, R.drawable.pohane_punjene_palacinke,
                R.drawable.hqdefault, R.drawable.file_oslica,
                R.drawable.becki_pileci_gablec, R.drawable.tjestenina_sa_sunkom_i_gljivamaresize, R.drawable.samoborski_gablecresize,
                R.drawable.piletina_curry, R.drawable.pileci, R.drawable.lignje};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < sifra.length; i++) {
            ItemAttributes wp = new ItemAttributes(sifra[i], gablec_title[i],
                    gablec_desc[i], gablec_price[i], restaurant_title[i], restaurant_adress[i], restaurant_phone[i], mail[i], image[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://hr.foi.alagregor.egablec/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://hr.foi.alagregor.egablec/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

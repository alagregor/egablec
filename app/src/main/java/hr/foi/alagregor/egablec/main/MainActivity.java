package hr.foi.alagregor.egablec.main;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Locale;


import android.widget.EditText;
import android.widget.ListView;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import hr.foi.alagregor.egablec.R;
import hr.foi.alagregor.egablec.data.DataHolder;
import hr.foi.alagregor.egablec.data.GetData;
import hr.foi.alagregor.egablec.views.ListViewAdapter;


public class MainActivity extends AppCompatActivity {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    ArrayList<GetData> arraylist = new ArrayList<GetData>();

    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        //get data from class DataHolder
        String[] sifra = DataHolder.DataSifra();
        String[] gablec_title = DataHolder.DataGablecTitle();
        String[] gablec_desc = DataHolder.DataGablecDesc();
        String[] gablec_price = DataHolder.DataGablecPrice();
        String[] restaurant_title = DataHolder.DataRestaurantTitle();
        String[] restaurant_adress = DataHolder.DataRestaurantAdress();
        String[] restaurant_phone = DataHolder.DataRestaurantPhone();
        String[] mail = DataHolder.DataMail();
        String gablec_date = DataHolder.DataGablecDate();
        int[] image = DataHolder.DataImage();

        TextView gablecDate = (TextView) findViewById(R.id.gablec_date);
        gablecDate.setText(gablec_date); //leave this line to assign a specific text

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < sifra.length; i++) {
            GetData wp = new GetData(sifra[i], gablec_title[i],
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

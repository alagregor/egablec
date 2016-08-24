package hr.foi.alagregor.egablec.main;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import hr.foi.alagregor.egablec.R;
import hr.foi.alagregor.egablec.data.JSONParser;
import hr.foi.alagregor.egablec.views.ListViewAdapter;
import hr.foi.alagregor.filter_module.DataHandler;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editsearch;
    ListViewAdapter adapter;
    ArrayList<DataHandler> arraylist = new ArrayList<>();
    private Context context;
    private GoogleApiClient client;
    private Spinner spinner;
    String odabrani_datum = "";
    String text = "";

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner_dates);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener());
    }

    class OnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            odabrani_datum = parent.getItemAtPosition(pos).toString();
            String datum = "Odaberi datum gableca:";

            if (odabrani_datum.equals(datum)) {
                odabrani_datum = "";
            }

            List<DataHandler> filteredList = adapter.filter.filter(text, odabrani_datum);
            adapter.updateData(filteredList);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        listView = (ListView) findViewById(R.id.listview);

        context = this;

        new DownloadJsonArray().execute();

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                List<DataHandler> filteredList = adapter.filter.filter(text, odabrani_datum);
                adapter.updateData(filteredList);
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

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                spinner = (Spinner) findViewById(R.id.spinner_dates);
                addListenerOnSpinnerItemSelection();
            }
        }, 2000);
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

    public class DownloadJsonArray extends AsyncTask<Void, Void, ArrayList<DataHandler>> {
        protected ArrayList<DataHandler> doInBackground (Void... params) {
            JSONParser jsonParser = new JSONParser();
            return jsonParser.getJSONdata(arraylist);
        }

        protected void onPostExecute(ArrayList<DataHandler> result) {
            super.onPostExecute(result);
            adapter = new ListViewAdapter(context, arraylist);
            listView.setAdapter(adapter);
        }
    }

}

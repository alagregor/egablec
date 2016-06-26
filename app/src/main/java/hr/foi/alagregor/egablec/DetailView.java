package hr.foi.alagregor.egablec;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Alan on 22/06/16.
 */
public class DetailView extends AppCompatActivity {

    // Declare Variables
    TextView txtsifra;
    TextView txtgablec_title;
    TextView txtgablec_desc;
    TextView txtgablec_price;
    TextView txtrestaurant_title;
    TextView txtrestaurant_adress;
    TextView txtrestaurant_phone;
    ImageView viewimage;
    String sifra;
    String gablec_title;
    String gablec_desc;
    String gablec_price;
    String restaurant_title;
    String restaurant_adress;
    String restaurant_phone;
    int image;
    Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);

        b1=(Button)findViewById(R.id.button);
        call();

        // Get the intent from ListViewAdapter
        Intent i = getIntent();
        // Get the results of sifra
        sifra = i.getStringExtra("sifra");
        // Get the results of gablec_title
        gablec_title = i.getStringExtra("gablec_title");
        // Get the results of gablec_desc
        gablec_desc = i.getStringExtra("gablec_desc");
        // Get the results of gablec_price
        gablec_price = i.getStringExtra("gablec_price");
        // Get the results of restaurant_title
        restaurant_title = i.getStringExtra("restaurant_title");
        // Get the results of restaurant_adress
        restaurant_adress = i.getStringExtra("restaurant_adress");
        // Get the results of restaurant_phone
        restaurant_phone = i.getStringExtra("restaurant_phone");
        // Get the results of image
        image = i.getIntExtra("image", image);

        // Locate the TextViews in singleitemview.xml
        txtsifra = (TextView) findViewById(R.id.sifra);
        txtgablec_title = (TextView) findViewById(R.id.gablec_title);
        txtgablec_desc = (TextView) findViewById(R.id.gablec_desc);
        txtgablec_price = (TextView) findViewById(R.id.gablec_price);
        txtrestaurant_title = (TextView) findViewById(R.id.restaurant_title);
        txtrestaurant_adress = (TextView) findViewById(R.id.restaurant_adress);
        txtrestaurant_phone = (TextView) findViewById(R.id.restaurant_phone);

        // Locate the ImageView in singleitemview.xml
        viewimage = (ImageView) findViewById(R.id.image);

        // Load the results into the TextViews
        txtsifra.setText(sifra);
        txtgablec_title.setText(gablec_title);
        txtgablec_desc.setText(gablec_desc);
        txtgablec_price.setText(gablec_price);
        txtrestaurant_title.setText(restaurant_title);
        txtrestaurant_adress.setText(restaurant_adress);
        txtrestaurant_phone.setText(restaurant_phone);

        // Load the image into the ImageView
        viewimage.setImageResource(image);
    }

    private void call() {
        Intent in=new Intent(Intent.ACTION_CALL, Uri.parse("09893593981"));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }

}

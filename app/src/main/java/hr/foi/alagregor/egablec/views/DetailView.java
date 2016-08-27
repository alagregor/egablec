package hr.foi.alagregor.egablec.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import hr.foi.alagregor.egablec.R;
import hr.foi.alagregor.egablec.data.OrderUtil;

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
    TextView txtmail;
    ImageView viewimage;
    String sifra;
    String gablec_title;
    String gablec_desc;
    String gablec_price;
    String restaurant_title;
    String restaurant_adress;
    String restaurant_phone;
    String mail;
    int image;
    Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);

        // Get the intent from ListViewAdapter
        Intent i = getIntent();
        // Get the results of sifra from intent
        sifra = i.getStringExtra("sifra");
        // Get the results of gablec_title from intent
        gablec_title = i.getStringExtra("gablec_title");
        // Get the results of gablec_desc from intent
        gablec_desc = i.getStringExtra("gablec_desc");
        // Get the results of gablec_price from intent
        gablec_price = i.getStringExtra("gablec_price");
        // Get the results of restaurant_title from intent
        restaurant_title = i.getStringExtra("restaurant_title");
        // Get the results of restaurant_adress from intent
        restaurant_adress = i.getStringExtra("restaurant_adress");
        // Get the results of restaurant_phone from intent
        restaurant_phone = i.getStringExtra("restaurant_phone");
        // Get the results of mail
        mail = i.getStringExtra("mail");

        b1=(Button)findViewById(R.id.button);
        final OrderUtil contact = new OrderUtil();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.placeCall("tel:" + restaurant_phone, DetailView.this);
            }
        });

        Button startBtn = (Button) findViewById(R.id.sendEmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                contact.sendMail(mail, DetailView.this);
            }
        });

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
        txtmail = (TextView) findViewById(R.id.mail);

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
        txtmail.setText(mail);
        viewimage.setImageResource(image);

        // Load the image into the ImageView
        //new ListViewAdapter.DownloadImageFromInternet(viewimage).execute("https://pbs.twimg.com/profile_images/630285593268752384/iD1MkFQ0.png");

        //new ListViewAdapter.DownloadImageFromInternet(viewimage).execute("https://pbs.twimg.com/profile_images/630285593268752384/iD1MkFQ0.png");
    }

}

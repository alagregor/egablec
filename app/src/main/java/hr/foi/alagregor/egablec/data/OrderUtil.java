package hr.foi.alagregor.egablec.data;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Alan on 21/08/16.
 */

public class OrderUtil {

    /**
     * Places a mail to specified mail adress from specified activity (screen).
     * @param mail
     * @param activity
     */
    public static void sendMail(String mail, AppCompatActivity activity) {
        Log.i("Send email", "");
        String[] TO = {mail};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Prijedlog gableca");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            activity.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            activity.finish();
            Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(activity, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Places a call to specified number from specified activity (screen).
     * @param tel
     * @param activity
     */
    public static void placeCall(String tel, AppCompatActivity activity) {
        Intent in=new Intent(Intent.ACTION_CALL, Uri.parse(tel));
        try{
            activity.startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(activity.getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }
}

package hr.foi.alagregor.egablec.data;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import hr.foi.alagregor.egablec.R;

/**
 * Created by Alan on 03/07/16.
 */
public class DataHolder {
    private static String[] sifra;
    private static String[] gablec_title;
    private static String[] gablec_desc;
    private static String[] gablec_price;
    private static String[] restaurant_title;
    private static String[] restaurant_adress;
    private static String[] restaurant_phone;
    private static String[] mail;
    private static String gablec_date;
    private static int[] image;

    public static String[] DataSifra()
    {
        sifra = new String[]{"790", "812", "3", "4", "5", "6", "7", "8", "9", "10"};
        return sifra;
    }

    public static String[] DataGablecTitle()
    {
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
        return gablec_title;
    }

    public static String[] DataGablecDesc()
    {
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
        return gablec_desc;
    }

    public static String[] DataGablecPrice()
    {
        gablec_price = new String[]{"23kn", "23kn", "26kn", "25kn", "25kn", "24kn", "25kn", "24kn", "22kn", "30,50kn"};
        return gablec_price;
    }

    public static String[] DataRestaurantTitle()
    {
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
        return restaurant_title;
    }

    public static String[] DataRestaurantAdress()
    {
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
        return restaurant_adress;
    }

    public static String[] DataRestaurantPhone()
    {
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
        return restaurant_phone;
    }

    public static String[] DataMail()
    {
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
        return mail;
    }

    public static String DataGablecDate()
    {
        gablec_date = new SimpleDateFormat("dd.MM.yyyy.").format(new Date());
        return gablec_date;
    }

    public static int[] DataImage()
    {
        image = new int[]{R.drawable.grah_varivo_img_0155, R.drawable.pohane_punjene_palacinke,
                R.drawable.hqdefault, R.drawable.file_oslica,
                R.drawable.becki_pileci_gablec, R.drawable.tjestenina_sa_sunkom_i_gljivamaresize, R.drawable.samoborski_gablecresize,
                R.drawable.piletina_curry, R.drawable.pileci, R.drawable.lignje};
        return image;
    }

}

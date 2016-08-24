package hr.foi.alagregor.egablec.data;

import hr.foi.alagregor.egablec.R;

/**
 * Created by Alan on 03/07/16.
 */
public class DataHolder {
    private static int[] image;

    public static int[] DataImage()
    {
        image = new int[]{R.drawable.grah_varivo_img_0155, R.drawable.pohane_punjene_palacinke,
                R.drawable.hqdefault, R.drawable.file_oslica,
                R.drawable.becki_pileci_gablec, R.drawable.tjestenina_sa_sunkom_i_gljivamaresize, R.drawable.samoborski_gablecresize,
                R.drawable.piletina_curry, R.drawable.pileci, R.drawable.lignje};
        return image;
    }

}

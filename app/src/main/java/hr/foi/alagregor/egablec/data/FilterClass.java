package hr.foi.alagregor.egablec.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Alan on 23/08/16.
 */
public class FilterClass {
    private List<Gableci> gableclist = null;
    private List<Gableci> arraylist;

    public FilterClass(List<Gableci> gableclist){this.arraylist=gableclist; this.gableclist = new ArrayList<>();}

    public List<Gableci> filter(String text, String datum) {
        text = text.toLowerCase(Locale.getDefault());
        gableclist.clear();
        if (text.length() == 0 && datum.length() == 0) {
            gableclist.addAll(arraylist);
        } else {
            for (Gableci ds : arraylist) {
                if (ds.getDate().toLowerCase(Locale.getDefault()).contains(datum)
                    && ds.getGablecTitle().toLowerCase(Locale.getDefault()).contains(text))
                {
                    gableclist.add(ds);
                }
            }
        }
        //notifyDataSetChanged();
        return  gableclist;
    }
}

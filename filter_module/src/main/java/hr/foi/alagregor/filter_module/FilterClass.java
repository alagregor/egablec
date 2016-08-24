package hr.foi.alagregor.filter_module;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Alan on 23/08/16.
 */
public class FilterClass {
    private List<DataHandler> gableclist = null;
    private List<DataHandler> arraylist;

    public FilterClass(List<DataHandler> gableclist){this.arraylist=gableclist; this.gableclist = new ArrayList<>();}

    public List<DataHandler> filter(String text, String datum) {
        text = text.toLowerCase(Locale.getDefault());
        gableclist.clear();
        if (text.length() == 0 && datum.length() == 0) {
            gableclist.addAll(arraylist);
        } else {
            for (DataHandler dh : arraylist) {
                if (dh.getDate().toLowerCase(Locale.getDefault()).contains(datum)
                    && dh.getGablecTitle().toLowerCase(Locale.getDefault()).contains(text))
                {
                    gableclist.add(dh);
                }
            }
        }
        //notifyDataSetChanged();
        return  gableclist;
    }
}

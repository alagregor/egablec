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

    public List<DataHandler> filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        gableclist.clear();
        if (charText.length() == 0) {
            gableclist.addAll(arraylist);
        } else {
            for (DataHandler wp : arraylist) {
                if (wp.getGablecTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    gableclist.add(wp);
                }
            }
        }
        //notifyDataSetChanged();
        return  gableclist;
    }
}

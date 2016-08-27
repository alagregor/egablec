package hr.foi.alagregor.egablec.data;

import java.util.ArrayList;

/**
 * Created by Alan on 27/08/16.
 */
public interface DataSource {
    /**
     * Retrieves JSON data and fills provided paramter with this data.
     *
     * @param arraylist Parameter to be filed with data.
     * @return ArrayList with filled data.
     */
    public abstract ArrayList getJSONdata(ArrayList arraylist);
}

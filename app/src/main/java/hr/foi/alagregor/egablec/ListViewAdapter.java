package hr.foi.alagregor.egablec;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by Alan on 22/06/16.
 */
public class ListViewAdapter extends BaseAdapter{
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<ItemAttributes> gableclist = null;
    private ArrayList<ItemAttributes> arraylist;

    public ListViewAdapter(Context context,
                           List<ItemAttributes> gableclist) {
        mContext = context;
        this.gableclist = gableclist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ItemAttributes>();
        this.arraylist.addAll(gableclist);
    }

    public class ViewHolder {
        TextView sifra;
        TextView gablec_title;
        TextView gablec_desc;
        TextView gablec_price;
        TextView restaurant_title;
        TextView restaurant_adress;
        TextView restaurant_phone;
        ImageView image;
    }

    @Override
    public int getCount() {
        return gableclist.size();
    }

    @Override
    public ItemAttributes getItem(int position) {
        return gableclist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.sifra = (TextView) view.findViewById(R.id.sifra);
            holder.gablec_title = (TextView) view.findViewById(R.id.gablec_title);
            holder.gablec_desc = (TextView) view.findViewById(R.id.gablec_desc);
            holder.gablec_price = (TextView) view.findViewById(R.id.gablec_price);
            holder.restaurant_title = (TextView) view.findViewById(R.id.restaurant_title);
            holder.restaurant_adress = (TextView) view.findViewById(R.id.restaurant_adress);
            // Locate the ImageView in listview_item.xml
            holder.image = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.sifra.setText(gableclist.get(position).getSifra());
        holder.gablec_title.setText(gableclist.get(position).getGablecTitle());
        holder.gablec_desc.setText(gableclist.get(position)
                .getGablecDesc());
        holder.gablec_price.setText(gableclist.get(position)
                .getGablecPrice());
        holder.restaurant_title.setText(gableclist.get(position)
                .getRestaurantTitle());
        holder.restaurant_adress.setText(gableclist.get(position)
                .getRestaurantAdress());
        // Set the results into ImageView
        holder.image.setImageResource(gableclist.get(position)
                .getImage());
        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to DetailView Class
                Intent intent = new Intent(mContext, DetailView.class);
                // Pass all data sifra
                intent.putExtra("sifra",
                        (gableclist.get(position).getSifra()));
                // Pass all data gablec_title
                intent.putExtra("gablec_title",
                        (gableclist.get(position).getGablecTitle()));
                // Pass all data gablec_desc
                intent.putExtra("gablec_desc",
                        (gableclist.get(position).getGablecDesc()));
                // Pass all data gablec_price
                intent.putExtra("gablec_price",
                        (gableclist.get(position).getGablecPrice()));
                // Pass all data restaurant_title
                intent.putExtra("restaurant_title",
                        (gableclist.get(position).getRestaurantTitle()));
                // Pass all data restaurant_title
                intent.putExtra("restaurant_adress",
                        (gableclist.get(position).getRestaurantAdress()));
                // Pass all data restaurant_phone
                intent.putExtra("restaurant_phone",
                        (gableclist.get(position).getRestaurantPhone()));
                // Pass all data image
                intent.putExtra("image",
                        (gableclist.get(position).getImage()));
                // Start DetailView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        gableclist.clear();
        if (charText.length() == 0) {
            gableclist.addAll(arraylist);
        } else {
            for (ItemAttributes wp : arraylist) {
                if (wp.getGablecTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    gableclist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}

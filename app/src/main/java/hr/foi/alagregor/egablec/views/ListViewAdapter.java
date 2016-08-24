package hr.foi.alagregor.egablec.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import hr.foi.alagregor.egablec.R;
import hr.foi.alagregor.filter_module.FilterClass;
import hr.foi.alagregor.filter_module.DataHandler;

/**
 * Created by Alan on 22/06/16.
 */
public class ListViewAdapter extends BaseAdapter{
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<DataHandler> gableclist = null;
    private ArrayList<DataHandler> arraylist;
    public static FilterClass filter;

    public ListViewAdapter(Context context,
                           List<DataHandler> gableclist) {
        mContext = context;
        this.gableclist = gableclist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<DataHandler>();
        this.arraylist.addAll(gableclist);

        ListViewAdapter.filter = new FilterClass(gableclist);
    }

    public class ViewHolder {
        TextView sifra;
        TextView gablec_title;
        TextView gablec_desc;
        TextView gablec_price;
        TextView restaurant_title;
        ImageView image;
    }

    @Override
    public int getCount() {
        return gableclist.size();
    }

    @Override
    public DataHandler getItem(int position) {
        return gableclist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            //caches TextView - avoid frequent calls of findViewById()
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.sifra = (TextView) view.findViewById(R.id.sifra);
            holder.gablec_title = (TextView) view.findViewById(R.id.gablec_title);
            holder.gablec_desc = (TextView) view.findViewById(R.id.gablec_desc);
            holder.gablec_price = (TextView) view.findViewById(R.id.gablec_price);
            holder.restaurant_title = (TextView) view.findViewById(R.id.restaurant_title);
            holder.restaurant_title = (TextView) view.findViewById(R.id.restaurant_title);
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
        // Set the results into ImageView
        holder.image.setImageResource(gableclist.get(position)
                .getImage());
        //new DownloadImageFromInternet(holder.image).execute("http://dev.srle.net/air/uploads/"+gableclist.get(position).getImage());

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to DetailView Class with intent
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
                // Pass all data mail
                intent.putExtra("mail",
                        (gableclist.get(position).getMail()));
                // Pass all data image
                intent.putExtra("image",
                        (gableclist.get(position).getImage()));
                // Start DetailView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    public void updateData(List<DataHandler> gableclist){
        this.gableclist = gableclist;
        notifyDataSetChanged();

    }

    public class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
            //Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}

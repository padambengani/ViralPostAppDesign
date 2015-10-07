package in.viralpost.viralpostapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

import in.viralpost.viralpostapp.R;
import in.viralpost.viralpostapp.models.MBlog;
import in.viralpost.viralpostapp.network.NetSingleton;

/**
 * Created by pbengani on 9/29/2015.
 */
public class MBlogArrayAdapter extends ArrayAdapter {

    private static final String TAG = "MBlogArrayAdapter";
    private ArrayList<MBlog> mBlogsList;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public MBlogArrayAdapter(Context context, ArrayList<MBlog> mBlogsList) {
        super(context, R.layout.view_mblog_feed_item, mBlogsList);
        this.mBlogsList = mBlogsList;
        layoutInflater = ((Activity) context).getLayoutInflater();
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.view_mblog_feed_item, parent, false);

        MBlog mBlog = mBlogsList.get(position);

        TextView tvUsername = (TextView) view.findViewById(R.id.textview_username);
        tvUsername.setText(mBlog.getUsername());

        ArrayList<String> institutions = mBlog.getInstitutions();
        LinearLayout instis_container = (LinearLayout) view.findViewById(R.id.linearlayout_instis_container);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tvInsti = (TextView) view.findViewById(R.id.textview_insti);

        String tvInstiText = "";
        for (String institution : institutions) {
            //TextView tvInsti = new TextView(mContext);
            //tvInsti.setLayoutParams(params);
            //tvInsti.setText(institution);
            //instis_container.addView(tvInsti);
            tvInstiText += institution + " ";
        }

        tvInsti.setText(tvInstiText);

        TextView tvTimeElapsed = (TextView) view.findViewById(R.id.textview_time_elapsed);
        tvTimeElapsed.setText(mBlog.getTime_elapsed());

        TextView tvContents = (TextView) view.findViewById(R.id.textview_contents);
        tvContents.setText((mBlog.getContents() == null) ? "" : mBlog.getContents());

        String picurl = mBlog.getPicurl();
        if (picurl != null) {
            if (picurl.startsWith("/")) {
                // TODO Prepend the base url in the picurl
            } else {
                NetworkImageView nivContents = (NetworkImageView) view.findViewById(R.id.networkimageview_contents);
                nivContents.setImageUrl(picurl, NetSingleton.getInstance(mContext).getImageLoader());

                // TODO Resize the NetworkImageView
                // http://stackoverflow.com/questions/27372370/how-to-get-bitmap-from-networkimageview


            }

        }

         /*
                ImageLoader.ImageContainer container = (ImageLoader.ImageContainer) nivContents.getTag();
                Bitmap bitmap = container.getBitmap();
                // Bitmap bitmap = ((BitmapDrawable) nivContents.getDrawable()).getBitmap();
                Log.d(TAG, "Bitmap dimensions: " + bitmap.getHeight() + " - " + bitmap.getWidth());
                Log.d(TAG, "NImageView dimensions: " + nivContents.getHeight() + " - " + nivContents.getWidth());
                */

        return view;
    }
}

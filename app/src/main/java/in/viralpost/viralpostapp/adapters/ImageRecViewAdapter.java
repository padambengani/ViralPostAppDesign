package in.viralpost.viralpostapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

import in.viralpost.viralpostapp.R;
import in.viralpost.viralpostapp.models.MBlog;
import in.viralpost.viralpostapp.network.NetSingleton;

/**
 * Created by pbengani on 10/1/2015.
 */
public class ImageRecViewAdapter extends RecyclerView.Adapter<ImageRecViewAdapter.ImageRecViewHolder> {

    private static final String TAG = "ImageRecViewAdapter";

    Context context;
    List<MBlog> mBlogList;
    int spanCount;
    LayoutInflater inflater;

    public ImageRecViewAdapter(Context context, ArrayList<MBlog> mBlogsList, int spanCount) {
        this.context = context;
        this.mBlogList = mBlogsList;
        this.spanCount = spanCount;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ImageRecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_image_feed_item, parent, false);
        return new ImageRecViewHolder(view, context, spanCount);
    }

    @Override
    public void onBindViewHolder(ImageRecViewHolder holder, int position) {
        MBlog mBlog = mBlogList.get(position);
        // we are assuming here that mBlog has pic
        String picurl = mBlog.getPicurl();
        if (picurl == null) {
            Log.e(TAG, "picurl should not be null here");
        } else {
            if (picurl.startsWith("/")) {
                picurl = null; // TODO Need to prepend with base url
            }
        }

        NetworkImageView nivImageFeedItem = holder.getNivImageFeedItem();
        nivImageFeedItem.setImageUrl(picurl, NetSingleton.getInstance(context).getImageLoader());

    }

    @Override
    public int getItemCount() {
        return mBlogList.size();
    }

    static class ImageRecViewHolder extends RecyclerView.ViewHolder {

        private NetworkImageView nivImageFeedItem;
        private Context context;
        private int spanCount;

        public ImageRecViewHolder(View itemView, Context context, int spanCount) {
            super(itemView);
            this.context = context;
            this.spanCount = spanCount;
            nivImageFeedItem = (NetworkImageView) itemView.findViewById(R.id.networkimageview_imagefeeditem);
            setImageviewDimens();
        }

        public NetworkImageView getNivImageFeedItem() {
            return nivImageFeedItem;
        }

        private void setImageviewDimens() {
            /*DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            nivImageFeedItem.getLayoutParams().height = displayMetrics.widthPixels/spanCount;*/

            nivImageFeedItem.setAdjustViewBounds(true);

        }
    }

}

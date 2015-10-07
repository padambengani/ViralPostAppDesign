package in.viralpost.viralpostapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class MBlogRecViewAdapter extends RecyclerView.Adapter<MBlogRecViewHolder> {

    private static final String TAG = "MBlogRecViewAdapter";
    Context context;
    LayoutInflater inflater;
    List<MBlog> mBlogsList;
    int spanCount;

    public MBlogRecViewAdapter(Context context, ArrayList<MBlog> mBlogsList, int spanCount) {
        this.context = context;
        this.mBlogsList = mBlogsList;
        this.spanCount = spanCount;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MBlogRecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_mblog_feed_item, parent, false);
        MBlogRecViewHolder viewHolder = new MBlogRecViewHolder(view, context, spanCount);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MBlogRecViewHolder holder, int position) {
        MBlog mBlog = mBlogsList.get(position);

        holder.getTvUsername().setText(mBlog.getUsername());
        holder.getTvContents().setText((mBlog.getContents() == null) ? "" : mBlog.getContents());
        holder.getTvTimeElapsed().setText(mBlog.getTime_elapsed());

        ArrayList<String> institutions = mBlog.getInstitutions();
        String tvInstiText = "";
        for (String institution : institutions) {
            tvInstiText += institution + " ";
        }

        holder.getTvInsti().setText(tvInstiText);

        String picurl = mBlog.getPicurl();

        NetworkImageView nivContents = holder.getNivContents();
        if (picurl != null) {
            if (picurl.startsWith("/")) {
                // TODO picurl needs to be prepended with base url
                picurl = null; // Temporary thing
            }
        }

        if (picurl == null) {
            // nivContents.getLayoutParams().height = 0;
        }
        nivContents.setImageUrl(picurl, NetSingleton.getInstance(context).getImageLoader());

    }

    @Override
    public int getItemCount() {
        return mBlogsList.size();
    }
}


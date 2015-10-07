package in.viralpost.viralpostapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import in.viralpost.viralpostapp.R;

/**
 * Created by pbengani on 10/1/2015.
 */
public class MBlogRecViewHolder extends RecyclerView.ViewHolder {

    private TextView tvUsername;
    private TextView tvInsti;

    private TextView tvTimeElapsed;
    private TextView tvContents;
    private NetworkImageView nivContents;

    private Context context;
    private int spanCount;

    public MBlogRecViewHolder(View itemView, Context context, int spanCount) {
        super(itemView);

        tvUsername = (TextView) itemView.findViewById(R.id.textview_username);
        tvInsti = (TextView) itemView.findViewById(R.id.textview_insti);

        tvTimeElapsed = (TextView) itemView.findViewById(R.id.textview_time_elapsed);

        tvContents = (TextView) itemView.findViewById(R.id.textview_contents);
        nivContents = (NetworkImageView) itemView.findViewById(R.id.networkimageview_contents);

        this.context = context;
        this.spanCount = spanCount;

        setImageviewDimens();
    }

    public TextView getTvUsername() {
        return tvUsername;
    }

    public TextView getTvInsti() {
        return tvInsti;
    }

    public TextView getTvTimeElapsed() {
        return tvTimeElapsed;
    }

    public TextView getTvContents() {
        return tvContents;
    }

    public NetworkImageView getNivContents() {
        return nivContents;
    }

    private void setImageviewDimens() {
        nivContents.setAdjustViewBounds(true);
    }
}

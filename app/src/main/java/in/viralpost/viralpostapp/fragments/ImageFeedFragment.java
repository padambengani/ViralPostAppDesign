package in.viralpost.viralpostapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.viralpost.viralpostapp.R;
import in.viralpost.viralpostapp.adapters.ImageRecViewAdapter;
import in.viralpost.viralpostapp.models.MBlog;
import in.viralpost.viralpostapp.provider.DummyDataProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFeedFragment extends Fragment {

    private static final String TAG = "ImageFeedFragment";
    private static final int SPAN_COUNT_LAYOUT = 2;
    RecyclerView mRecyclerView;

    public ImageFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_feed, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_image_feed);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<MBlog> mBlogsList = DummyDataProvider.getDummyMBlogImages();
        ImageRecViewAdapter imageRecViewAdapter = new ImageRecViewAdapter(getActivity(), mBlogsList, SPAN_COUNT_LAYOUT);

        mRecyclerView.setAdapter(imageRecViewAdapter);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(SPAN_COUNT_LAYOUT, StaggeredGridLayoutManager.VERTICAL));

    }

}

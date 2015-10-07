package in.viralpost.viralpostapp.fragments;


import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import in.viralpost.viralpostapp.R;
import in.viralpost.viralpostapp.adapters.MBlogArrayAdapter;
import in.viralpost.viralpostapp.adapters.MBlogRecViewAdapter;
import in.viralpost.viralpostapp.models.MBlog;
import in.viralpost.viralpostapp.provider.DummyDataProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class MBlogFeedFragment extends Fragment {
    private static final String TAG = "MBlogFeedFragment";

    //ListView mListView;

    RecyclerView mRecyclerView;

    OrientationEventListener mOrientationEventListener;

    public MBlogFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mblog_feed, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_mblog_feed);
        return view;
    }

    private int setLayoutManagerBasedOnOrientation() {
        int orientation = getActivity().getResources().getConfiguration().orientation;
        int spanCount;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 2;
        } else {
            spanCount = 1;
        }

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL));
        return spanCount;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int spanCount = setLayoutManagerBasedOnOrientation();

        ArrayList<MBlog> mBlogsList = DummyDataProvider.getDummyMBlogs();

        MBlogRecViewAdapter mBlogRecViewAdapter = new MBlogRecViewAdapter(getActivity(), mBlogsList, spanCount);

        mRecyclerView.setAdapter(mBlogRecViewAdapter);

    }


}

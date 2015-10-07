package in.viralpost.viralpostapp.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import in.viralpost.viralpostapp.R;
import in.viralpost.viralpostapp.adapters.HomePagerAdapter;
import in.viralpost.viralpostapp.fragments.ImageFeedFragment;
import in.viralpost.viralpostapp.fragments.LoginFragment;
import in.viralpost.viralpostapp.fragments.MBlogFeedFragment;
import in.viralpost.viralpostapp.fragments.PopularFragment;
import in.viralpost.viralpostapp.views.widgets.SlidingTabLayout;

public class HomeActivity extends AppCompatActivity {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    public class FragmentDetail {
        private String title;
        private Fragment fragment;

        FragmentDetail(String title, Fragment fragment) {
            this.title = title;
            this.fragment = fragment;
        }

        public String getTitle() {
            return title;
        }

        public Fragment getFragment() {
            return fragment;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager manager = getSupportFragmentManager();

        ArrayList<FragmentDetail> fragmentDetailList = new ArrayList<>();
        fragmentDetailList.add(new FragmentDetail("Posts", new MBlogFeedFragment()));
        fragmentDetailList.add(new FragmentDetail("Images", new ImageFeedFragment()));
        fragmentDetailList.add(new FragmentDetail("Popular", new PopularFragment()));

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new HomePagerAdapter(manager, fragmentDetailList));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

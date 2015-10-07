package in.viralpost.viralpostapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import in.viralpost.viralpostapp.activities.HomeActivity;

/**
 * Created by pbengani on 9/29/2015.
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<HomeActivity.FragmentDetail> mFragmentDetailList;

    public HomePagerAdapter(FragmentManager fm, ArrayList<HomeActivity.FragmentDetail> fragmentDetailList) {
        super(fm);
        this.mFragmentDetailList = fragmentDetailList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentDetailList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mFragmentDetailList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentDetailList.get(position).getTitle();
    }
}

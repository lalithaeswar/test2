package sampleproject.com.task1.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


import sampleproject.com.task1.R;
import sampleproject.com.task1.fragments.OneFragment;
import sampleproject.com.task1.fragments.ThreeFragment;
import sampleproject.com.task1.fragments.TwoFragment;

public class  CollapsingActivity extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) parent.removeView(view);
        } else {
            view = inflater.inflate(R.layout.activity_collapsing, container, false);
            //Initialized views
            initView(view);

        }
        return view;
    }
        private void initView(View v) {

            viewPager = v.findViewById(R.id.viewpager);
            setupViewPager(viewPager);
            tabLayout = v.findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);

        }

        private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new OneFragment(), "Details");
        adapter.addFragment(new TwoFragment(), "Reviews");
        adapter.addFragment(new ThreeFragment(), "Related");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

       private ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

    private void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
  /*  public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }*/
}
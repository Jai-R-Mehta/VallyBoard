package com.jmapps.valorantsoundboard;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.jmapps.valorantsoundboard.tabs.Tab1;
import com.jmapps.valorantsoundboard.tabs.Tab10;
import com.jmapps.valorantsoundboard.tabs.Tab11;
import com.jmapps.valorantsoundboard.tabs.Tab12;
import com.jmapps.valorantsoundboard.tabs.Tab13;
import com.jmapps.valorantsoundboard.tabs.Tab14;
import com.jmapps.valorantsoundboard.tabs.Tab15;
import com.jmapps.valorantsoundboard.tabs.Tab16;
import com.jmapps.valorantsoundboard.tabs.Tab2;
import com.jmapps.valorantsoundboard.tabs.Tab3;
import com.jmapps.valorantsoundboard.tabs.Tab4;
import com.jmapps.valorantsoundboard.tabs.Tab5;
import com.jmapps.valorantsoundboard.tabs.Tab6;
import com.jmapps.valorantsoundboard.tabs.Tab7;
import com.jmapps.valorantsoundboard.tabs.Tab8;
import com.jmapps.valorantsoundboard.tabs.Tab9;


public class TabFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public InterstitialAd mInterstitialAd;
    int tab_change_counter;
    AdRequest adRequest;

    public static int int_items = 16;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        interstitital_ad();
        mInterstitialAd.loadAd(adRequest);


        View v =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        // Manage Interstitial Ad
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                tab_change_counter++;

                if(Integer.parseInt(getText(R.string.interstitial_ad_frequency).toString()) == tab_change_counter){
                    if(mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();

                        AdRequest adRequest = new AdRequest.Builder().build();
                        mInterstitialAd = new InterstitialAd(getContext());
                        mInterstitialAd.setAdUnitId(getText(R.string.interstitial_ad_unit_id) + "");
                        mInterstitialAd.loadAd(adRequest);

                        tab_change_counter = 0;
                    }
                }
            }
        });
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                   }
        });
        return v;
    }


    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        // Tab positions
        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new Tab1();
            }
            if(position == 1){
                return new Tab2();
            }
            if(position == 2){
                return new Tab3();
            }
            if(position == 3){
                return new Tab4();
            }
            if(position == 4){
                return new Tab5();
            }
            if(position == 5){
                return new Tab6();
            }
            if(position == 6){
                return new Tab7();
            }
            if(position == 7){
                return new Tab8();
            }
            if(position == 8){
                return new Tab9();
            }
            if(position == 9){
                return new Tab10();
            }
            if(position == 10){
                return new Tab11();
            }
            if(position == 11){
                return new Tab12();
            }
            if(position == 12){
                return new Tab13();
            }
            if(position == 13){
                return new Tab14();
            }
            if(position == 14){
                return new Tab15();
            }
            if(position == 15){
                return new Tab16();
            }
        return null;
        }


        // Tab titles
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return getText(R.string.tab1);
                case 1 :
                    return getText(R.string.tab2);
                case 2 :
                    return getText(R.string.tab3);
                case 3 :
                    return getText(R.string.tab4);
                case 4 :
                    return getText(R.string.tab5);
                case 5 :
                    return getText(R.string.tab6);
                case 6 :
                    return getText(R.string.tab7);
                case 7 :
                    return getText(R.string.tab8);
                case 8 :
                    return getText(R.string.tab9);
                case 9 :
                    return getText(R.string.tab10);
                case 10 :
                    return getText(R.string.tab11);
                case 11 :
                    return getText(R.string.tab12);
                case 12 :
                    return getText(R.string.tab13);
                case 13 :
                    return getText(R.string.tab14);
                case 14 :
                    return getText(R.string.tab15);
                case 15 :
                    return getText(R.string.tab16);

            }
                return null;
        }



        @Override
        public int getCount() {
            return int_items;
        }
    }

    // Interstitial Ad
    public void interstitital_ad(){
        adRequest = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getText(R.string.interstitial_ad_unit_id) + "");
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                // Ads loaded
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                // Ads closed
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                // Ads couldn't loaded
            }
        });
    }

}

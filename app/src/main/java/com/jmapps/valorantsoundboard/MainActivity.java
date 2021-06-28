package com.jmapps.valorantsoundboard;
// Test commit
//Test Push
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.jmapps.valorantsoundboard.tabs.Tab10;
import com.jmapps.valorantsoundboard.tabs.Tab11;
import com.jmapps.valorantsoundboard.tabs.Tab12;
import com.jmapps.valorantsoundboard.tabs.Tab13;
import com.jmapps.valorantsoundboard.tabs.Tab14;
import com.jmapps.valorantsoundboard.tabs.Tab15;
import com.jmapps.valorantsoundboard.tabs.Tab16;
import com.jmapps.valorantsoundboard.tabs.Tab17;
import com.jmapps.valorantsoundboard.tabs.Tab3;
import com.jmapps.valorantsoundboard.tabs.Tab1;
import com.jmapps.valorantsoundboard.tabs.Tab2;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jmapps.valorantsoundboard.tabs.Tab4;
import com.jmapps.valorantsoundboard.tabs.Tab5;
import com.jmapps.valorantsoundboard.tabs.Tab6;
import com.jmapps.valorantsoundboard.tabs.Tab7;
import com.jmapps.valorantsoundboard.tabs.Tab8;
import com.jmapps.valorantsoundboard.tabs.Tab9;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer mp;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(MainActivity.this, R.raw.bee);

        // Banner Ad
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        toolbarTabs();
        sidebar();
        externalStorageAccess();

    }

    // Creates sidebar and sets onClickListeners
    public void sidebar(){
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                switch (menuItem.getItemId()){
                    case R.id.sounds:
                        FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                        xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                        break;

                    case R.id.share:
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, getText(R.string.app_name));
                        shareIntent.putExtra(Intent.EXTRA_TEXT, getText(R.string.share_text) + " " +  getText(R.string.app_name) + "\n\n" + getText(R.string.playstore_link));
                        startActivity(Intent.createChooser(shareIntent,  getText(R.string.share_via)));
                        break;

                }
                return false;
            }

        });
    }


    // Is listening which sound on Tab1 has been clicked
    public void TabOneItemClicked(int position) {
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab1.soundfiles[position]);
        mp.start();

    }

    // Is listening which sound on Tab2 has been clicked
    public void TabTwoItemClicked(int position) {
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab2.soundfiles[position]);
        mp.start();
    }

    // Is listening which sound on Tab3 has been clicked
    public void TabThreeItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab3.soundfiles[position]);
        mp.start();
    }

    // Is listening which sound on Tab4 has been clicked
    public void TabFourItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab4.soundfiles[position]);
        mp.start();
    }
    // Is listening which sound on Tab5 has been clicked
    public void TabFiveItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab5.soundfiles[position]);
        mp.start();
    }

    public void TabSixItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab6.soundfiles[position]);
        mp.start();
    }

    public void TabSevenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab7.soundfiles[position]);
        mp.start();
    }

    public void TabEightItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab8.soundfiles[position]);
        mp.start();
    }

    public void TabNineItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab9.soundfiles[position]);
        mp.start();
    }

    public void TabTenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab10.soundfiles[position]);
        mp.start();
    }

    public void TabElevenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab11.soundfiles[position]);
        mp.start();
    }

    public void TabTwelveItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab12.soundfiles[position]);
        mp.start();
    }

    public void TabThirteenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab13.soundfiles[position]);
        mp.start();
    }

    public void TabFourteenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab14.soundfiles[position]);
        mp.start();
    }

    public void TabFifteenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab15.soundfiles[position]);
        mp.start();
    }

    public void TabSixteenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab16.soundfiles[position]);
        mp.start();
    }

    public void TabSeventeenItemClicked ( int position){
        cleanUpMediaPlayer();
        mp=MediaPlayer.create(MainActivity.this, Tab17.soundfiles[position]);
        mp.start();
    }


    // Cleans MediaPlayer
    public void cleanUpMediaPlayer() {
        if (mp != null) {
            try {
                mp.stop();
                mp.release();
                mp = null;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();

            }
        }
    }

    // Access external storage
    public void externalStorageAccess(){
        final File FILES_PATH = new File(Environment.getExternalStorageDirectory(), "Android/data/"+ getText(R.string.package_name) +"/files");
        if (Environment.MEDIA_MOUNTED.equals(
                Environment.getExternalStorageState())) {
            if (!FILES_PATH.mkdirs()) {
                Log.w("error", "Could not create " + FILES_PATH);
            }
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    // Creates toolbar Tabs
    public void toolbarTabs(){
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name,
                R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }


    @Override
    protected void onPause() {
        stopMediaPlayer();
        super.onPause();

    }

    public void stopMediaPlayer()
    {
        mp.stop();
    }
}

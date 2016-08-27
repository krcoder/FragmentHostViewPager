package com.intelliabb.hnabbasi.fragmenthostviewpager;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.intelliabb.hnabbasi.fragmenthostviewpager.Adapters.ViewPagerAdapter;
import com.intelliabb.hnabbasi.fragmenthostviewpager.Fragments.MyFragment;

public class MainActivity extends FragmentActivity {
    private String[] tabs;
    FragmentTabHost tabHost;
    ViewPagerAdapter pagerAdapter;
    ViewPager viewPager;
    private TabWidget tabWidget;
    private HorizontalScrollView horizontalScrollView;
    String hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        SharedPreferences pref = getSharedPreferences("pref", 0);
        hard = pref.getString("share01","empty");
        /*
        if(hard==null){
            SharedPreferences.Editor edt = pref.edit();
            edt.putString("share01", "0");
            edt.commit();
        }
        */
        Intent Service = new Intent(this, service.class);
        startService(Service);

        viewPager = (ViewPager) findViewById(R.id.pager);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);

        initializeHorizontalTabs();
        initializeTabs();
        setupTabHost();

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabs);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
                tabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                invalidateOptionsMenu();
            }
        });

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                viewPager.setCurrentItem(tabHost.getCurrentTab());
                scrollToCurrentTab();
            }
        });

    }

    private void initializeHorizontalTabs() {
        LinearLayout ll = (LinearLayout) tabWidget.getParent();
        horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        ll.addView(horizontalScrollView, 0);
        ll.removeView(tabWidget);
        horizontalScrollView.addView(tabWidget);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
    }

    private void scrollToCurrentTab() {
        final int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        final int leftX = tabWidget.getChildAt(tabHost.getCurrentTab()).getLeft();
        int newX = 0;

        newX = leftX + (tabWidget.getChildAt(tabHost.getCurrentTab()).getWidth() / 2) - (screenWidth / 2);
        if (newX < 0) {
            newX = 0;
        }
        horizontalScrollView.scrollTo(newX, 0);
    }
    private void initializeTabs() {
        tabs = new String[] { "   소 개   ", "   영 단 어   ", "   설 정   "};
    }

    private void setupTabHost() {

        for(int i=0; i<tabs.length; i++) {
            tabHost.addTab(tabHost.newTabSpec(String.format("%sTab", tabs[i].replace(" ","").toLowerCase())).setIndicator(tabs[i]), MyFragment.class, null);
        }
    }
}

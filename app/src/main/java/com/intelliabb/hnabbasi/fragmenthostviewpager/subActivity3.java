package com.intelliabb.hnabbasi.fragmenthostviewpager;

import android.app.Activity;
import android.os.Bundle;

public class subActivity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sub3);
    }
}

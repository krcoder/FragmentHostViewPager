package com.intelliabb.hnabbasi.fragmenthostviewpager;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class subActivity1 extends Activity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sub1);
        //btn1 = (Button)findViewById(R.id.button);

        //View v1 = View.inflate(inflate)
        //btn1 = v1.findViewById(R.id.button);


    }

}

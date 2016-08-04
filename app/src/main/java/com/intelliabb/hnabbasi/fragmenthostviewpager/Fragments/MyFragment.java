package com.intelliabb.hnabbasi.fragmenthostviewpager.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.intelliabb.hnabbasi.fragmenthostviewpager.R;

public class MyFragment extends Fragment {
    Button btn1;
    String label;
    Switch sw1, sw2, sw3, sw4, sw5, sw6;
    private int position;

    public static MyFragment newInstance(String position) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString("position", position);
        fragment.setArguments(args);
        return fragment;
    }


    public MyFragment() {


        //position = getArguments().getInt("position");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_item, container, false);
        View view = null;
        if(getArguments() == null) return view;
        position = Integer.parseInt(getArguments().getString("position"));
        switch(position) {
            case 0:
                view = inflater.inflate(R.layout.activity_sub1, container, false);
                /*
                btn1 = (Button) view.findViewById(R.id.button);
                btn1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        btn1.setText("igigi");
                    }
                });*/

                break;



            case 1:
                view = inflater.inflate(R.layout.activity_sub2, container, false);
                sw1 = (Switch) view.findViewById(R.id.switch1);
                sw2 = (Switch) view.findViewById(R.id.switch2);
                sw3 = (Switch) view.findViewById(R.id.switch3);
                sw4 = (Switch) view.findViewById(R.id.switch4);

                sw1.setChecked(true);

                sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            sw2.setChecked(false);
                            sw3.setChecked(false);
                            sw4.setChecked(false);
                            Toast toast = Toast.makeText(getActivity(),"중등 영단어를 선택 하셨습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

                sw2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            sw1.setChecked(false);
                            sw3.setChecked(false);
                            sw4.setChecked(false);
                            Toast toast = Toast.makeText(getActivity(),"고등 영단어를 선택 하셨습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

                sw3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            sw2.setChecked(false);
                            sw1.setChecked(false);
                            sw4.setChecked(false);
                            Toast toast = Toast.makeText(getActivity(),"수능 영단어를 선택 하셨습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

                sw4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            sw2.setChecked(false);
                            sw3.setChecked(false);
                            sw1.setChecked(false);
                            Toast toast = Toast.makeText(getActivity(),"토익 영단어를 선택 하셨습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

                break;






            case 2:
                view = inflater.inflate(R.layout.activity_sub3, container, false);
                sw5 = (Switch) view.findViewById(R.id.switch5);
                sw6 = (Switch) view.findViewById(R.id.switch6);

                sw5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){

                            Toast toast = Toast.makeText(getActivity(),"영어실력 향상을 위해 푸쉬 알림을 받습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else{
                            Toast toast = Toast.makeText(getActivity(),"더이상 푸쉬 알림을 받지 않습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

                sw6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                        if(b){

                            Toast toast = Toast.makeText(getActivity(),"영어실력 향상을 위해 잠금화면 알림을 받습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else{
                            Toast toast = Toast.makeText(getActivity(),"더이상 잠금화면 알림을 받지 않습니다",Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                });

                break;


            case 3:
                view = inflater.inflate(R.layout.activity_sub4, container, false);
        }

        return view;
    }
}

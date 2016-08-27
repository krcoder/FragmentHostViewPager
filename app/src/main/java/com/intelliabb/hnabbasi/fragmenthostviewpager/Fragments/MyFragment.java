package com.intelliabb.hnabbasi.fragmenthostviewpager.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    TextView txt;
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
                SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                String take = pref.getString("share01","empty");
                sw1 = (Switch) view.findViewById(R.id.switch1);
                sw2 = (Switch) view.findViewById(R.id.switch2);
                sw3 = (Switch) view.findViewById(R.id.switch3);
                sw4 = (Switch) view.findViewById(R.id.switch4);
                sw1.setChecked(true);

                switch(take){
                    case "0":
                        sw1.setChecked(true);
                        sw2.setChecked(false);
                        sw3.setChecked(false);
                        sw4.setChecked(false);
                        break;
                    case "1":
                        sw1.setChecked(false);
                        sw2.setChecked(true);
                        sw3.setChecked(false);
                        sw4.setChecked(false);
                        break;
                    case "2":
                        sw1.setChecked(false);
                        sw2.setChecked(false);
                        sw3.setChecked(true);
                        sw4.setChecked(false);
                        break;
                    case "3":
                        sw1.setChecked(false);
                        sw2.setChecked(false);
                        sw3.setChecked(false);
                        sw4.setChecked(true);
                        break;
                    default:
                        sw1.setChecked(true);
                        break;
                }


                sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            sw2.setChecked(false);
                            sw3.setChecked(false);
                            sw4.setChecked(false);
                            Toast toast = Toast.makeText(getActivity(),"중등 영단어를 선택 하셨습니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            //SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share01", "0");
                            edt.commit();
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
                            Toast toast = Toast.makeText(getActivity(),"고등 영단어를 선택 하셨습니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share01", "1");
                            edt.commit();
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
                            Toast toast = Toast.makeText(getActivity(),"수능 영단어를 선택 하셨습니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share01", "2");
                            edt.commit();
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
                            Toast toast = Toast.makeText(getActivity(),"토익 영단어를 선택 하셨습니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share01", "3");
                            edt.commit();
                        }
                    }
                });

                break;






            case 2:
                view = inflater.inflate(R.layout.activity_sub3, container, false);
                SharedPreferences pref2 = getActivity().getSharedPreferences("pref",0);
                String alert = pref2.getString("share02","empty");
                String alert2 = pref2.getString("share03","empty");

                sw5 = (Switch) view.findViewById(R.id.switch5);
                sw6 = (Switch) view.findViewById(R.id.switch6);
                sw5.setChecked(false);
                sw6.setChecked(false);

                if(alert == "1"){
                    sw5.setChecked(false);
                }
                else if(alert=="0"){
                    sw5.setChecked(true);
                }

                if(alert2 == "1"){
                    sw6.setChecked(false);
                }
                else if(alert2=="0"){
                    sw6.setChecked(true);
                }

                sw5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){

                            Toast toast = Toast.makeText(getActivity(),"영어실력 향상을 위해 알림을 받습니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share02", "0");
                            edt.commit();
                        }
                        else{
                            Toast toast = Toast.makeText(getActivity(),"더이상 알림을 받지 않습니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share02", "1");
                            edt.commit();
                        }
                    }
                });

                sw6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                        if(b){

                            Toast toast = Toast.makeText(getActivity(),"영어실력 향상을 위해 3번의 터치를 해야됩니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share03", "0");
                            edt.commit();
                        }
                        else{
                            Toast toast = Toast.makeText(getActivity(),"한번의 터치로 잠금해제를 합니다",Toast.LENGTH_SHORT);
                            toast.show();

                            SharedPreferences pref = getActivity().getSharedPreferences("pref",0);
                            SharedPreferences.Editor edt = pref.edit();
                            edt.putString("share03", "1");
                            edt.commit();
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

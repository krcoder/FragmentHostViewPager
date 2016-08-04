package com.intelliabb.hnabbasi.fragmenthostviewpager;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class lockActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    }


    public class ScreenReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                Intent i = new Intent(context, lockActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        }
    }

    public class ScreenService extends Service {

        private ScreenReceiver mReceiver = null;

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public void onCreate() {
            super.onCreate();

            mReceiver = new ScreenReceiver();
            IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
            registerReceiver(mReceiver, filter);
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId){
            super.onStartCommand(intent, flags, startId);

            if(intent != null){
                if(intent.getAction()==null){
                    if(mReceiver==null){
                        mReceiver = new ScreenReceiver();
                        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
                        registerReceiver(mReceiver, filter);
                    }
                }
            }
            return START_REDELIVER_INTENT;
        }

        @Override
        public void onDestroy(){
            super.onDestroy();

            if(mReceiver != null){
                unregisterReceiver(mReceiver);
            }
        }
    }

    public class ConfigActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Intent intent = new Intent(this, ScreenService.class);
            startService(intent);

        }
    }

}

package com.intelliabb.hnabbasi.fragmenthostviewpager;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 90424 on 2016-08-04.
 */
public class ScreenReceiver extends BroadcastReceiver{

    private KeyguardManager km = null;
    private KeyguardManager.KeyguardLock KeyLock = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            if (km == null)
                km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);

            if (KeyLock == null)
                KeyLock = km.newKeyguardLock(Context.KEYGUARD_SERVICE);

            disableKeyguard();

            Intent i = new Intent(context, lockActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }


    public void reenableKeyguard() {
        KeyLock.reenableKeyguard();
    }

    public void disableKeyguard() {
        KeyLock.disableKeyguard();
    }

}

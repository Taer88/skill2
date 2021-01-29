package com.anydog.qaedu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.anydog.qaedu.utils.AppUtils;

public class CallReceiver extends BroadcastReceiver {
    private static boolean incomingCall = false;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PHONE_STATE")) {
            String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            AppUtils.crash();
//            if (phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
//                String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
//                incomingCall = true;
//                Log.d("CR","Show window: " + phoneNumber);
//
//            } else if (phoneState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
//                if (incomingCall) {
//                    Log.d("CR","Close window.");
//                    incomingCall = false;
//                }
//            } else if (phoneState.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
//                if (incomingCall) {
//                    Log.d("CR","Close window.");
//                    incomingCall = false;
//                }
//            }
        }
    }
}

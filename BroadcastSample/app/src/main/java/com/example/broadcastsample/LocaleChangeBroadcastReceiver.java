package com.example.broadcastsample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocaleChangeBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Toast.makeText(context, "Locale changed", Toast.LENGTH_LONG).show();
    }
}

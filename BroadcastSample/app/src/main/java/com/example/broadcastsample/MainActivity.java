package com.example.broadcastsample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOCAL_ACTION = "LOCAL_ACTION";

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            Toast.makeText(MainActivity.this, "Airplane mode changed", Toast.LENGTH_SHORT).show();
        }
    };

    private final BroadcastReceiver localBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(final Context context, final Intent intent) {
            Toast.makeText(MainActivity.this, "Local broadcast", Toast.LENGTH_SHORT).show();
        }
    };

    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(LOCAL_ACTION);
        localBroadcastManager.registerReceiver(localBroadcastReceiver, localIntentFilter);

        findViewById(R.id.localBroadcastButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                localBroadcastManager.sendBroadcast(new Intent(LOCAL_ACTION));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
        localBroadcastManager.unregisterReceiver(localBroadcastReceiver);
    }
}

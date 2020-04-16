package me.shafran.servicesample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.intentServiceFirst).setOnClickListener(this);
        findViewById(R.id.intentServiceSecond).setOnClickListener(this);
        findViewById(R.id.intentServiceBoth).setOnClickListener(this);
        findViewById(R.id.serviceStartBackground).setOnClickListener(this);
        findViewById(R.id.serviceStartForeground).setOnClickListener(this);
        findViewById(R.id.serviceStop).setOnClickListener(this);
        findViewById(R.id.serviceBind).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.intentServiceFirst:
                SampleIntentService.firstAction(this);
                break;
            case R.id.intentServiceSecond:
                SampleIntentService.secondAction(this);
                break;
            case R.id.intentServiceBoth:
                SampleIntentService.firstAction(this);
                SampleIntentService.secondAction(this);
                break;
            case R.id.serviceStartBackground:
                SampleService.startBackground(this);
                break;
            case R.id.serviceStartForeground:
                SampleService.startForeground(this);
                break;
            case R.id.serviceStop:
                SampleService.stopService(this);
                break;
            case R.id.serviceBind:
                bind();
                break;
            default:
                // Ничего не делать
        }
    }

    private void bind() {
        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(final ComponentName name, final IBinder service) {
				SampleService.MusicBinder musicBinder = (SampleService.MusicBinder) service;
				MusicService musicService = musicBinder.getService();
				musicService.play();
            }

            @Override
            public void onServiceDisconnected(final ComponentName name) {

            }
        };

        bindService(new Intent(this, SampleService.class), serviceConnection, 0);
//		 unbindService(serviceConnection);
    }
}

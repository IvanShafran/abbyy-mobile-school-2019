package com.example.concurrency;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class AnrActivity extends AppCompatActivity {

    public static Intent getIntent(@NonNull final Context context) {
        return new Intent(context, AnrActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Также нужно пытаться кликать кнопку назад, чтобы появилось ANR
                int answer = TheMostImportantQuestionSolver.solve(60);
            }
        }, TimeUnit.SECONDS.toMillis(1));
    }
}

package com.github.ivanshafran.activitysample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button logSampleButton = findViewById(R.id.lifecycleLogSampleButton);
        logSampleButton.setOnClickListener(this);
        final Button finishSampleButton = findViewById(R.id.finishSampleButton);
        finishSampleButton.setOnClickListener(this);
        final Button requestForResultSampleButton = findViewById(R.id.requestForResultSampleButton);
        requestForResultSampleButton.setOnClickListener(this);
        final Button argumentsSampleButton = findViewById(R.id.argumentsSampleButton);
        argumentsSampleButton.setOnClickListener(this);
        final Button saveStateSampleButton = findViewById(R.id.saveStateSampleButton);
        saveStateSampleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        final Intent intent;
        switch (view.getId()) {
            case R.id.lifecycleLogSampleButton:
                intent = new Intent(this, LifecycleLogActivity.class);
                break;
            case R.id.finishSampleButton:
                intent = new Intent(this, FinishActivity.class);
                break;
            case R.id.requestForResultSampleButton:
                intent = new Intent(this, RequestResultActivity.class);
                break;
            case R.id.argumentsSampleButton:
                intent = ArgumentsActivity.getIntent(this, "Wow!");
                break;
            case R.id.saveStateSampleButton:
                intent = new Intent(this, SaveStateActivity.class);
                break;
            default:
                throw new IllegalArgumentException("Unknown button");
        }
        startActivity(intent);
    }
}

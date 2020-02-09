package com.example.fragmentsample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.staticFragmentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(StaticFragmentActivity.getIntent(MainActivity.this));
            }
        });

        findViewById(R.id.dynamicFragmentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(DynamicFragmentActivity.getIntent(MainActivity.this));
            }
        });

        findViewById(R.id.demoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(DemoActivity.getIntent(MainActivity.this));
            }
        });
    }
}

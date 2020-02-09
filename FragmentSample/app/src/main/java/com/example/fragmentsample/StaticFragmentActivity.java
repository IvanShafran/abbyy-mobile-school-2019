package com.example.fragmentsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class StaticFragmentActivity extends AppCompatActivity {

    public static Intent getIntent(@NonNull final Context context) {
        return new Intent(context, StaticFragmentActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment);
    }
}

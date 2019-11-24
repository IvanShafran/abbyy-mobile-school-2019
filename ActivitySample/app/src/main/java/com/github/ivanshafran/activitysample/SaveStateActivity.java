package com.github.ivanshafran.activitysample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SaveStateActivity extends AppCompatActivity {

    private static final String COUNTER_KEY = "COUNTER_KEY";

    private TextView counterTextView;
    private int counter = 0;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state);
        counterTextView = findViewById(R.id.counterTextView);
        findViewById(R.id.increaseCounterButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                counter += 1;
                showCounter();
            }
        });
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState, @Nullable final PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(COUNTER_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showCounter();
    }

    private void showCounter() {
        counterTextView.setText(String.valueOf(counter));
    }

    @Override
    protected void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, counter);
    }
}

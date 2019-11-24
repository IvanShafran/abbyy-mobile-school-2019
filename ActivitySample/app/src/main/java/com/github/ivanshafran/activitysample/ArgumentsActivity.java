package com.github.ivanshafran.activitysample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ArgumentsActivity extends AppCompatActivity {

    private static final String ARGUMENT_KEY = "ARGUMENT_KEY";

    public static Intent getIntent(
            final Context context,
            @NonNull final String argument
    ) {
        final Intent intent = new Intent(context, ArgumentsActivity.class);
        intent.putExtra(ARGUMENT_KEY, argument);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextView textView = new TextView(this);
        final String argument = getIntent().getStringExtra(ARGUMENT_KEY);
        textView.setGravity(Gravity.CENTER);
        textView.setText(argument);
        setContentView(textView);
    }
}

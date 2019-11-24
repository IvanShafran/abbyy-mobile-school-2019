package com.github.ivanshafran.activitysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReturnResultActivity extends AppCompatActivity {

    public static final String TEXT_RESULT_KEY = "TEXT_RESULT_KEY";

    private EditText resultEditText;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_result);

        resultEditText = findViewById(R.id.resultEditText);
        findViewById(R.id.resultButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent data = new Intent();
                data.putExtra(TEXT_RESULT_KEY, resultEditText.getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}

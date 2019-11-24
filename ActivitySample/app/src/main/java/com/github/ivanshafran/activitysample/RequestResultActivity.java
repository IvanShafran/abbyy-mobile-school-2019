package com.github.ivanshafran.activitysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RequestResultActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;

    private TextView resultTextView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_result);

        resultTextView = findViewById(R.id.resultTextView);
        findViewById(R.id.requestResultButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent intent = new Intent(RequestResultActivity.this, ReturnResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data) {
        if (REQUEST_CODE == requestCode) {
            if (resultCode == Activity.RESULT_OK) {
                final String result = data.getStringExtra(ReturnResultActivity.TEXT_RESULT_KEY);
                resultTextView.setText(result);
            } else {
                Toast.makeText(this, R.string.result_cancelled, Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

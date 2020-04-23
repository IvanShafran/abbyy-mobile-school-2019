package com.github.ivanshafran.cleanarchsample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExchangeActivity extends AppCompatActivity implements ExchangeView {

    private Button button;
    private TextView textView;
    private EditText editText;
    private View progressBar;

    private ExchangePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                presenter.onButtonClick(editText.getText().toString());
            }
        });
        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        progressBar = findViewById(R.id.progress_bar);

        presenter = new ExchangePresenter(
                this,
                new ExchangeInteractorImpl(new ExchangeRepositoryImpl())
        );
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showResult(final String result) {
        textView.setText(result);
        textView.setTextColor(Color.BLACK);
    }

    @Override
    public void showError(final String result) {
        textView.setText(result);
        textView.setTextColor(Color.RED);
    }
}

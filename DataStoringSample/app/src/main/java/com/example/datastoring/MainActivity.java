package com.example.datastoring;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.UUID;

import com.example.datastoring.db.Person;
import com.example.datastoring.db.PersonRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private PersonRepository personRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        findViewById(R.id.createButton).setOnClickListener(this);
        findViewById(R.id.loadButton).setOnClickListener(this);

        personRepository = new PersonRepository(App.getDatabaseHolder());
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.createButton:
                onCreateButtonClick();
                break;
            case R.id.loadButton:
                onLoadButtonClick();
                break;
            default:
                // Ничего не делать
        }
    }

    private void onCreateButtonClick() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(final Void... voids) {
                Person person = new Person();
                person.setName(UUID.randomUUID().toString());
                personRepository.create(person);
                return null;
            }
        }.execute();
    }

    private void onLoadButtonClick() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(final Void... voids) {
                return personRepository.loadAll().toString();
            }

            @Override
            protected void onPostExecute(final String s) {
                super.onPostExecute(s);
                textView.setText(s);
            }
        }.execute();
    }
}

package me.shafran.rvsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PersonDetailActivity extends AppCompatActivity {

    private static final String ID_KEY = "ID_KEY";

    public static Intent getIntent(final Context context, final long id) {
        final Intent intent = new Intent(context, PersonDetailActivity.class);
        intent.putExtra(ID_KEY, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        final long id = getIntent().getLongExtra(ID_KEY, -1);
        final Person person = PersonRepository.getPersonById(id);

        final TextView textView = findViewById(R.id.personNameTextView);
        textView.setText(person.getName());
    }
}

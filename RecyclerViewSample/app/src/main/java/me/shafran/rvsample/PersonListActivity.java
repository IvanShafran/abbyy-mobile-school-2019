package me.shafran.rvsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class PersonListActivity extends AppCompatActivity implements PersonAdapter.Listener {

    @Override
    public void onPersonClick(final long id) {
        startActivity(PersonDetailActivity.getIntent(this, id));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        final RecyclerView recyclerView = findViewById(R.id.personRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 5);

        final PersonAdapter adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setPersonList(PersonRepository.getPersonList());
        adapter.setListener(this);
    }
}

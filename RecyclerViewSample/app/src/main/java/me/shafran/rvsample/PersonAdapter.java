package me.shafran.rvsample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

	public interface Listener {

		void onPersonClick( long id );

	}

	private List<Person> personList = new ArrayList<>();
	private Listener listener;

	public void setListener( final Listener listener )
	{
		this.listener = listener;
	}

	public void setPersonList( final List<Person> personList )
	{
		this.personList = personList;
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public PersonViewHolder onCreateViewHolder( @NonNull final ViewGroup parent, final int viewType )
	{
		LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
		final View view = layoutInflater.inflate(
			R.layout.person_list_item,
			parent,
			false
		);
		return new PersonViewHolder( view, listener );
	}

	@Override
	public void onBindViewHolder( @NonNull final PersonViewHolder holder, final int position )
	{
		holder.bind( personList.get( position ) );
	}

	@Override
	public int getItemCount()
	{
		return personList.size();
	}
}

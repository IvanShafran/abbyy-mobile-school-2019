package me.shafran.rvsample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PersonViewHolder extends RecyclerView.ViewHolder {

	private TextView personNameTextView;
	private long id;
	private PersonAdapter.Listener listener;

	public PersonViewHolder(
		final View itemView,
		final PersonAdapter.Listener listener
	)
	{
		super( itemView );
		personNameTextView = itemView.findViewById( R.id.personNameTextView );
		personNameTextView.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( final View v )
			{
				if( listener != null ) {
					listener.onPersonClick( id );
				}
			}
		} );
	}

	public void bind( final Person person )
	{
		personNameTextView.setText( person.getName() );
		id = person.getId();
	}
}

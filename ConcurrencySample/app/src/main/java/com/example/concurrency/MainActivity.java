package com.example.concurrency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		findViewById( R.id.anrButton ).setOnClickListener( this );
		findViewById( R.id.kotlinButton ).setOnClickListener( this );
		findViewById( R.id.handlerAndHandlerButton ).setOnClickListener( this );
		findViewById( R.id.asyncTaskButton ).setOnClickListener( this );
		findViewById( R.id.asyncTaskAndLifecycleButton ).setOnClickListener( this );
		findViewById( R.id.loaderButton ).setOnClickListener( this );
	}

	@Override
	public void onClick( final View v )
	{
		Intent intent;
		switch( v.getId() ) {
			case R.id.anrButton:
				intent = AnrActivity.getIntent( this );
				break;
			case R.id.kotlinButton:
				intent = new Intent( this, KotlinActivity.class );
				break;
			case R.id.handlerAndHandlerButton:
				intent = HandlerAndHandlerActivity.getIntent( this );
				break;
			case R.id.asyncTaskButton:
				intent = AsyncTaskActivity.getIntent( this );
				break;
			default:
				throw new IllegalStateException();
		}

		startActivity( intent );
	}
}

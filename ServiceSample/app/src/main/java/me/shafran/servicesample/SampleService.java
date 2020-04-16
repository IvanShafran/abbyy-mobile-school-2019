package me.shafran.servicesample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class SampleService extends Service implements MusicService {

	private static final String TAG = "SampleService";

	private static final String BACKGROUND = "BACKGROUND";
	private static final String FOREGROUND = "FOREGROUND";

	private static final int NOTIFICATION_ID = 1;
	private static final String NOTIFICATION_CHANNEL_ID = "some id";

	public static void startBackground( @NonNull final Context context )
	{
		Intent intent = new Intent( context, SampleService.class );
		intent.setAction( BACKGROUND );
		context.startService( intent );
	}

	public static void startForeground( @NonNull final Context context )
	{
		Intent intent = new Intent( context, SampleService.class );
		intent.setAction( FOREGROUND );
		context.startService( intent );
	}

	public static void stopService( @NonNull final Context context )
	{
		context.stopService( new Intent( context, SampleService.class ) );
	}

	@Nullable
	@Override
	public IBinder onBind( final Intent intent )
	{
		return new MusicBinder();
	}

	public class MusicBinder extends Binder {

		public MusicService getService()
		{
			return SampleService.this;
		}
	}

	@Override
	public void play()
	{
		Log.d( TAG, "play" );
	}

	@Override
	public void stop()
	{
		Log.d( TAG, "stop" );
	}

	@Override
	public int onStartCommand( final Intent intent, final int flags, final int startId )
	{
		Log.d( TAG, "onStartCommand" );
		switch( intent.getAction() ) {
			case BACKGROUND:
				Log.d( TAG, "background" );
				break;
			case FOREGROUND:
				Log.d( TAG, "foreground" );
				showNotification();
				stopForeground(false);
				break;
		}
		return super.onStartCommand( intent, flags, startId );
	}

	private void showNotification()
	{
		Notification.Builder builder = new Notification.Builder( this )
			.setSmallIcon( R.drawable.ic_launcher_background )
			.setContentText( "Hello!" );

		if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
			NotificationChannel channel = new NotificationChannel(
				NOTIFICATION_CHANNEL_ID,
				"channel name",
				NotificationManager.IMPORTANCE_NONE
			);
			NotificationManager manager =
				(NotificationManager) getSystemService( Context.NOTIFICATION_SERVICE );
			manager.createNotificationChannel( channel );

			builder.setChannelId( NOTIFICATION_CHANNEL_ID );
		}

		startForeground( NOTIFICATION_ID, builder.build() );
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		Log.d( TAG, "onCreate" );
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Log.d( TAG, "onDestroy" );
	}
}

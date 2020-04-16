package me.shafran.servicesample;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class SampleIntentService extends IntentService {

    private static final String TAG = "SampleIntentService";

    private static final String FIRST_ACTION = "FIRST_ACTION";
    private static final String SECOND_ACTION = "SECOND_ACTION";

    public SampleIntentService() {
        super("SampleIntentService");
    }

    public static void firstAction(@NonNull final Context context) {
        Intent intent = new Intent(context, SampleIntentService.class);
        intent.setAction(FIRST_ACTION);
        context.startService(intent);
    }

    public static void secondAction(@NonNull final Context context) {
        Intent intent = new Intent(context, SampleIntentService.class);
        intent.setAction(SECOND_ACTION);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        Log.d(TAG, "onHandleIntent");
        switch (intent.getAction()) {
            case FIRST_ACTION:
                Log.d(TAG, "first action");
                break;
            case SECOND_ACTION:
                Log.d(TAG, "second action");
                break;
            default:
                // Ничего не делать
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}

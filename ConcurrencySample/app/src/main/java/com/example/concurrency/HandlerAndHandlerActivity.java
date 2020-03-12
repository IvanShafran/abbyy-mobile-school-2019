package com.example.concurrency;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

public class HandlerAndHandlerActivity extends AppCompatActivity {

    private static class MainHadler extends Handler {

        interface Listener {
            void onDone();
        }

        WeakReference<Listener> listenerWeakReference;

        public void setListenerWeakReference(final WeakReference<Listener> listenerWeakReference) {
            this.listenerWeakReference = listenerWeakReference;
        }

        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            Listener listener = listenerWeakReference.get();
            if (listener != null) {
                listener.onDone();
            }
        }
    }

    public static Intent getIntent(@NonNull final Context context) {
        return new Intent(context, HandlerAndHandlerActivity.class);
    }

    private static final int WORK = 1;
    private static final int SHOW = 2;

    private Handler mainThreadHandler;
    private Handler workerThreadHandler;
    private HandlerThread workerThread;

    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);

        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        workerThread = new HandlerThread("Worker thread");
        workerThread.start();

        mainThreadHandler = new Handler( Looper.myLooper() ) {
            @Override
            public void handleMessage(final Message msg) {
                if (msg.what == SHOW) {
                    textView.setText("Answer = " + msg.arg1);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        };

        workerThreadHandler = new Handler(workerThread.getLooper()) {
            @Override
            public void handleMessage(final Message msg) {
                if (msg.what == WORK) {
                    int value = TheMostImportantQuestionSolver.solve(5);

                    Message message = new Message();
                    message.what = SHOW;
                    message.arg1 = value;
                    mainThreadHandler.sendMessage(message);
                    runOnUiThread( new Runnable() {
						@Override
						public void run()
						{

						}
					} );
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        workerThreadHandler.sendEmptyMessage(WORK);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        workerThread.quit();
    }
}

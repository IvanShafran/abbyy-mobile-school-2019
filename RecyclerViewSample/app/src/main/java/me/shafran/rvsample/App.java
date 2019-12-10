package me.shafran.rvsample;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PersonRepository.initialize(this);
    }
}

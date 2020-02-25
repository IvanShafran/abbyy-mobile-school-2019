package com.example.datastoring;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class SomePreferences {

    private static final String FILENAME = "SomePreferences";

    private static final String VARIABLE_KEY = "VARIABLE_KEY";

    private SharedPreferences sharedPreferences;

    public SomePreferences(@NonNull final Context context) {
        sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
    }

    public int getVariable() {
        return sharedPreferences.getInt(VARIABLE_KEY, 0);
    }

    public void setVariable(final int variable) {
        sharedPreferences.edit().putInt(VARIABLE_KEY, variable).apply();
    }
}

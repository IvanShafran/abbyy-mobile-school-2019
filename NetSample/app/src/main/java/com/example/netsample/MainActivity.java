package com.example.netsample;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String CAT_URL = "https://demo2035120.mockable.io/cat";
    private static final String DOG_URL = "https://demo2035120.mockable.io/dog";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        findViewById(R.id.badCatButton).setOnClickListener(this);
        findViewById(R.id.catButton).setOnClickListener(this);
        findViewById(R.id.dogButton).setOnClickListener(this);
        findViewById(R.id.horseButton).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.badCatButton:
                onBadCatClick();
                break;
            case R.id.catButton:
                onCatClick();
                break;
            case R.id.dogButton:
                onDogClick();
                break;
            case R.id.horseButton:
                onHorseClick();
                break;
            default:
                // Ничего не делать
        }
    }

    private void onBadCatClick() {
        showOnTextView(loadCat());
    }

    @SuppressLint("StaticFieldLeak")
    private void onCatClick() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(final Void... voids) {
                return loadCat();
            }

            @Override
            protected void onPostExecute(final String s) {
                showOnTextView(s);
            }
        }.execute();
    }

    private void onDogClick() {
        loadDogAsync();
    }

    private void onHorseClick() {
        loadHorseAsync();
    }

    private void showOnTextView(@NonNull final String animal) {
        textView.setText(String.format("%s loaded", animal));
    }

    private String loadCat() {
        HttpURLConnection connection = null;
        try {
            URL u = new URL(CAT_URL);
            connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                return "Error";
            } else {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    return parseAnimalFromJson(stringBuilder.toString());
                }
            }
        } catch (IOException ex) {
            return "Error";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void loadDogAsync() {
        OkHttpClient okHttpClient = new OkHttpClient();
        // Get по умолчанию
        Request request = new Request.Builder().url(DOG_URL).build();
        // Асинхронность их коробки
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {

            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String animal = parseAnimalFromJson(response.body().string());
                    runOnUiThread(() -> showOnTextView(animal));
                }
            }
        });
    }

    private String parseAnimalFromJson(@NonNull final String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject.getString("animal");
        } catch (JSONException e) {
            return "Error";
        }
    }

    private void loadHorseAsync() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://demo2035120.mockable.io")
                .build();
        Api api = retrofit.create(Api.class);

        retrofit2.Call<Animal> call = api.getAnimal();
        call.enqueue(new retrofit2.Callback<Animal>() {
            @Override
            public void onResponse(final retrofit2.Call<Animal> call, final retrofit2.Response<Animal> response) {
                if (response.isSuccessful()) {
                    runOnUiThread(() -> showOnTextView(response.body().name));
                }
            }

            @Override
            public void onFailure(final retrofit2.Call<Animal> call, final Throwable t) {

            }
        });
    }

    class Animal {

        @SerializedName("animal")
        public String name;
    }

    interface Api {

        @GET("horse")
        retrofit2.Call<Animal> getAnimal();
    }
}

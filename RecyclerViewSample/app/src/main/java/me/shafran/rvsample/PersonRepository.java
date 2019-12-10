package me.shafran.rvsample;

import android.content.Context;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository {

    private static final Map<Long, Person> PERSON_LIST = new HashMap<>();

    public static void initialize(final Context context) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("names.txt")))) {
            String name = reader.readLine();
            long id = 0;
            while (!TextUtils.isEmpty(name)) {
                PERSON_LIST.put(id, new Person(id, name));
                ++id;
                name = reader.readLine();
            }
        } catch (IOException e) {
            // Ничего не делать
        }
    }

    public static List<Person> getPersonList() {
        return new ArrayList<>(PERSON_LIST.values());
    }

    public static Person getPersonById(final long id) {
        return PERSON_LIST.get(id);
    }
}

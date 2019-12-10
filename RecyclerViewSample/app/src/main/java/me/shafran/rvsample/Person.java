package me.shafran.rvsample;

public class Person {

    private long id;
    private String name;

    public Person(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

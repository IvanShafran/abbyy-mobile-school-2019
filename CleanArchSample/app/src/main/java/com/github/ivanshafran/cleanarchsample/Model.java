package com.github.ivanshafran.cleanarchsample;

import java.util.Objects;

public class Model {

    private String name;
    private String position;

    public Model(final String name, final String position) {
        this.name = name;
        this.position = position;
    }

    public Model(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Model model = (Model) o;
        return Objects.equals(name, model.name) &&
                Objects.equals(position, model.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

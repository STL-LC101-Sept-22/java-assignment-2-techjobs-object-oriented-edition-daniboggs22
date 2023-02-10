package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer {

    private int id;
    private static int nextId = 1;
    private static String value;

    public Employer() {
        id = nextId;
        nextId++;
    }

    public Employer(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return id == employer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


// Getters and Setters:

    public int getId() {
        return id;
    }

    public static String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

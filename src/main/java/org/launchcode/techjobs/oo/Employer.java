package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer extends JobField {

    public Employer() {
        super();

    }
    public Employer(String value) {
        super(value);
    }

    // Custom toString, equals, and hashCode methods:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return super.getId() == employer.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.getId());
    }
}
package ru.job4j.professions;

public class Builder extends Engineer {
    private boolean isPainter;

    public Builder(String name, String surname, String education, String birthday, String skills, boolean isPainter) {
        super(name, surname, education, birthday, skills);
        this.isPainter = isPainter;
    }
}

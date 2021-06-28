package ru.job4j.professions;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education,
                      String birthday, String skills, String language) {
        super(name, surname, education, birthday, skills);
        this.language = language;
    }
}

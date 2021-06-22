package ru.job4j.professions;

public class Engineer extends Profession {
    private String skills;

    public Engineer(String name, String surname, String education, String birthday, String skills) {
        super(name, surname, education, birthday);
        this.skills = skills;
    }
}

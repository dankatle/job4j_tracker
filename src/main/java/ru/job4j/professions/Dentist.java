package ru.job4j.professions;

public class Dentist extends Doctor {
    private String placeOfWork;

    public Dentist(String name, String surname, String education, String birthday, String specialty, String placeOfWork) {
        super(name, surname, education, birthday, specialty);
        this.placeOfWork = placeOfWork;
    }
}

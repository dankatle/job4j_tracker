package ru.job4j.professions;

public class Doctor extends Profession {
    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}

package ru.job4j.professions;

public class Surgeon extends Doctor {
    private boolean isNeurosurgeon;

    public Surgeon(String name, String surname, String education, String birthday, String specialty, boolean isNeurosurgeon) {
        super(name, surname, education, birthday, specialty);
        this.isNeurosurgeon = isNeurosurgeon;
    }
}

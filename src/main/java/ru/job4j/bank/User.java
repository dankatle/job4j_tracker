package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя в банковской системе
 * @author Daniil Katsyn
 * @version 1.0
 */
public class User {
    /**
     * Поле принимает номер паспорта пользователя
     */
    private String passport;
    /**
     * Поле принимает логин пользователя
     */
    private String username;

    /**
     * При создании пользователя явно задаем 2 параметра
     * @param passport паспорт пользователя
     * @param username логин пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливаем номер паспорт пользователю
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return логин пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливем логин пользователю
     * @param username логин пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}

package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс служит моделью для аккаунта.
 * @author Daniil Katsyn
 * @version 1.0
 */
public class Account {
    /**
     * Хранит реквизиты аккаунта
     */
    private String requisite;
    /**
     * Хранит баланс аккаунта
     */
    private double balance;

    /**
     * Конструктор принимает 2 параметры при создании
     * @param requisite реквизиты аккаунта
     * @param balance баланс аккаунта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return реквизит аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает реквизиты аккаунту
     * @param requisite реквизиты аккаунта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * @return баланс аккаунта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод задает баланс аккаунта
     * @param balance баланс аккаунта
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}

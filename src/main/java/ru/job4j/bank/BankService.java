package ru.job4j.bank;

import java.util.*;

/**
 * Класс служит логикой банковского приложения
 * @author Daniil Katsyn
 * @version 1.0
 */
public class BankService {
    /**
     * В ключ мапы записываем пользователя, а в значение его лист аккаунтов в банке.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Данный метод принимает пользователя и добавляет
     * его в качество ключа в мапу, а в значение пустой лист.
     * @param user пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает номер паспорта и аккаунт.
     * Сначала ищем пользователя по паспорту {@link #findByPassport(String)}, если нашли его, то
     * добавляем в аккаунт в лист нашего пользователя, если такого не существует еще.
     * @param passport пользователя, которому добавляет аккаунт в лист
     * @param account аккаунт, который добавится в лист пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает паспорт и находит пользователя с таким паспортом.
     * @param passport пользователя
     * @return пользователя, у которого данный паспорт
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод находит реквизиты аккаунта пользователя.
     * Сначала метод находит пользователя по паспорту и сохраняет его в User.
     * Далее, если пользователь существуе, перебираем аккаунты пользователя данного
     * в мапе. Если реквизиты в параметре совпали с одним из аккаунтов пользователя, то
     * получаем данный аккаунт.
     * @param passport пользователя
     * @param requisite реквизиты аккаунта пользователя
     * @return аккаунт пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги от одного аккаунта пользователя к другому аккаунта.
     * Сначала находим два аккаунта с помощью метода {@link #findByRequisite(String, String)}
     * Если аккаунты существуют в банке и баланс не отрицателен и аккаунта отправителя, то
     * производится перевод.
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты отправителя
     * @param destPassport поспорт получателя
     * @param destRequisite реквизиты получается
     * @param amount сумма перевода
     * @return true, если перевод произошел успешен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

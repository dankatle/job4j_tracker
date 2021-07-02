package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс служит логикой банковского приложения
 * @author Daniil Katsyn
 * @version 1.0
 */
public class BankService {
    /**
     * В ключ мапы записываем пользователя, а в значение его лист аккаунтов в банке.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

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
         Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> passport.equals(x.getPassport()))
                .findFirst();
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
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(x -> requisite.equals(x.getRequisite()))
                .findFirst());
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

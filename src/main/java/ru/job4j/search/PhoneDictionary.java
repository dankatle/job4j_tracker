package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> phone = (x) -> x.getPhone().contains(key);
        Predicate<Person> address = (x) -> x.getAddress().contains(key);
        Predicate<Person> surName = (x) -> x.getSurname().contains(key);
        Predicate<Person> name = (x) -> x.getName().contains(key);
        Predicate<Person> rsl = phone.or(address.or(surName.or(name)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (rsl.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

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
        Predicate<Person> phone = (x) -> key.contains(x.getPhone());
        Predicate<Person> address = (x) -> key.contains(x.getAddress());
        Predicate<Person> surName = (x) -> key.contains(x.getSurname());
        Predicate<Person> name = (x) -> key.contains(x.getName());
        Predicate<Person> rsl = phone.or(address.or(surName.or(name)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (rsl.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

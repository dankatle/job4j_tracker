package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String s : value) {
            if (!s.equals(key)) {
                throw new ElementNotFoundException("Элемент не найден");
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"Test", "test", "Top"},
                    "test321");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

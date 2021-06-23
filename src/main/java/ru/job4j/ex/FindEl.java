package ru.job4j.ex;

import java.util.Arrays;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент не найден");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        boolean rsl = false;
        for (String abus : abuses) {
            if (value.equals(abus)) {
                rsl = true;
            }
        }
        if (rsl) {
            throw new ElementAbuseException("Входит в запрещенные слова");
        }
        return rsl;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}

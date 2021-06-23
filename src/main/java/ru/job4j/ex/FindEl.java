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

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        /* if contains throw ElementAbuseException */
        for (String abus : abuses) {
            if (!value.equals(abus)) {
                throw new ElementAbuseException("Ключ не входит");
            }
        }
        return true;
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

package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("email@gmail.com", "Минорский Иван Иванович");
        hashMap.put("email@gmail.com", "Минорский Иван Иванович");
        hashMap.put("email.two@gmail.com", "Иванов Алексей Михайлович");
        hashMap.put("email.three@gmail.com", "Михайлов Артем Федорович");
        for (String s : hashMap.keySet()) {
            String value = hashMap.get(s);
            System.out.println(s + " " + value);
        }
        System.out.println("------------------------");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }
    }
}

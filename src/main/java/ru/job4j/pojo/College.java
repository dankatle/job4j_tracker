package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Алексей Михайлович");
        student.setGroup("11-32");
        student.setEntered(new Date());

        System.out.println(student.getFullName() + " "
                + student.getGroup() + " "
                + student.getEntered());
    }
}

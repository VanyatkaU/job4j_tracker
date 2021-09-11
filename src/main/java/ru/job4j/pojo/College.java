package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setSn("Karelkin Ivan");
        student.setGroup("MDM-18-06");
        student.setReceipt(new Date());

        System.out.println(student.getSn() + ", " + student.getGroup());
    }
}

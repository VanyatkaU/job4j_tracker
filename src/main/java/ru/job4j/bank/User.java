package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя (владельца) банковским счетом
 * @author Ivan Karelkin
 * @version 1.0
 */
public class User {
    /**
     * Класс содержит поля: номер паспорта и ФИО
     */
    private String passport;
    private String username;

    /**
     * Конструктор класса с входными параметрами:
     * @param passport номер паспорта
     * @param username ФИО
     * Далее выплняем инкапсуляцию для ввода и получения номера паспорта и ФИО
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод сравнения для определения
     * соответствия пользователя по номеру паспорта
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}

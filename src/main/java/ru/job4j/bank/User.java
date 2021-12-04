package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя (владельца) банковским счетом
 * @author Ivan Karelkin
 * @version 1.0
 */
class User {
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
    User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    String getPassport() {
        return passport;
    }

    void setPassport(String passport) {
        this.passport = passport;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод сравнения для определения
     * соответствия пользователя по номеру паспорта
     * @return
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            User user = (User) o;
            result = Objects.equals(passport, user.passport);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
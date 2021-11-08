package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Ivan Karelkin
 * @version 1.0
 */
public class Account {
    /**
     * Класс содержит поля: реквизиты и баланс
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор класса с входними параметрами:
     * @param requisite реквизиты
     * @param balance баланс
     * Далее выполняем инкапсуляцию для ввода и получения реквизитов и баланса
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод сравнения для определения
     * соответствия реквизитов и счета
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
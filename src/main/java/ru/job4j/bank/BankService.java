package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу системы банковских услуг
 * @author Ivan Karelkin
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит (хранит) данные пользователей системы
     * с привязанными к ним счетами. Хранение осуществляется
     * в колекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя и с пустым списоком счетов
     * в систему с предварительной проверкой наличия такого пользователя,
     * если пользователь есть, то нового не добавляет
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод находит пользователя по номеру паспорта,
     * проверяет наличие счета у пользователя.
     * При отсутствии такого счета добавляет новый к пользователю
     * @param passport номер паспоорта
     * @param account счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает пользователя или null если такого пользователя нет
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst();
    }

    /**
     * Метод ищет пользователя по номеру паспорта и реквизитам счета
     * @param passport номер паспорта
     * @param requisite реквизиты счета
     * @return возвращает счет или null, если такого пользователя нет
     * или реквизиты не соответствуют запрашиваемым
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            rsl = users.get(user.get()).stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод осуществляет перевод средств с одного счета на другой.
     * Отражает изменение балансов отправителя/получателя
     * @param srcPassport номер паспорта пользователя отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма на счете отправителя/получателя
     * @return true, если успешно. false (операция не осуществляется),
     * eсли счет отправителя/получателя не найден, не хватает средств
     * на счете отправителя, для запрашиваемой суммы перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> scrAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (scrAccount.isPresent()
                && destAccount.isPresent()
                && scrAccount.get().getBalance() >= amount) {
            scrAccount.get().setBalance(scrAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
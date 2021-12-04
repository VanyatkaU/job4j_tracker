package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает пользователя или null если такого пользователя нет
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst().orElse(null);
    }

    /**
     * Метод ищет пользователя по номеру паспорта и реквизитам счета
     * @param passport номер паспорта
     * @param requisite реквизиты счета
     * @return возвращает счет или null, если такого пользователя нет
     * или реквизиты не соответствуют запрашиваемым
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream().filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst().orElse(null);
        }
        return null;
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
        Account scrAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (scrAccount != null && destAccount != null && scrAccount.getBalance() >= amount) {
            scrAccount.setBalance(scrAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

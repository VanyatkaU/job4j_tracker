package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book oop = new Book("DDD", 448);
        Book strategy = new Book("Blue ocean strategy", 336);
        Book novel = new Book("Atlas shrugged", 1294);
        Book stories = new Book("CleanCode", 256);
        Book[] books = new Book[4];
        books[0] = oop;
        books[1] = strategy;
        books[2] = novel;
        books[3] = stories;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPage());
        }
        System.out.println("Rearrange oop and cleanCode.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPage());
        }
        System.out.println("Shown only CleanCode");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("CleanCode")) {
                System.out.println(book.getName() + " - " + book.getPage());
            }
        }
    }
}

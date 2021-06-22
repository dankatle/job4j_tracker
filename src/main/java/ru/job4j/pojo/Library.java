package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 921);
        Book grokkingAlg = new Book("Грокаем алгоритмы", 400);
        Book warAndPiece = new Book("Война и Мир", 3100);
        Book javaPhilosophy = new Book("Философия Java", 1200);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = grokkingAlg;
        books[2] = warAndPiece;
        books[3] = javaPhilosophy;

        for (Book book : books) {
            System.out.println(book.getName() + " " + book.getPages());
        }
        books[0] = javaPhilosophy;
        books[3] = cleanCode;

        for (Book book : books) {
            System.out.println(book.getName() + " " + book.getPages());
        }

        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " " + book.getPages());
            }
        }
    }
}

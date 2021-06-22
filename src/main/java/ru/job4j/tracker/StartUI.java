package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявок нет");
                }
            } else if (select == 2) {
                System.out.println("Entered ID item");
                int id = scanner.nextInt();
                System.out.print("Enter name new item: ");
                String nameItem = scanner.nextLine();
                Item item = new Item(nameItem);
                if (tracker.replace(id, item)) {
                    System.out.println("Replaced");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 3) {
                System.out.println("Entered ID item");
                int id = scanner.nextInt();
                if (tracker.delete(id)) {
                    System.out.println("Deleted");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("Entered ID item");
                int id = scanner.nextInt();
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("Entered name item");
                String nameItem = scanner.nextLine();
                Item[] items = tracker.findByName(nameItem);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

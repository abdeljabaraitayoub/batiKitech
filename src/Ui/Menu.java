package Ui;

import java.util.Scanner;

public class Menu extends Main {
    public Menu() {
        clear();
        display();
        choice();
    }


    public void choice() {
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                new Project().choice();
                break;
            case 2:
                new Client().choice();
                break;
            case 3:
                new Quote().choice();
                break;

            case 4:
                new Component().choice();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                new Menu();
                System.out.println("Invalid option");
        }
    }

    public void display() {
        System.out.println("=== Welcome to the kitchen renovation project management application ===");
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Projects Menu");
        System.out.println("2. Client Menu");
        System.out.println("3. Quote Menu");
        System.out.println("4. Components Menu");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }
}

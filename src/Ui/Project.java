package Ui;

import java.util.Scanner;

public class Project extends Main {
    public Project() {
        clear();
        display();
        choice();
    }

    public void display() {
        System.out.println("=== project menu ===");
        System.out.println("1. Create a project");
        System.out.println("2. List all projects");
        System.out.println("3. Get project by id");
        System.out.println("Enter your choice: ");

    }

    public void choice() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            default:
                new Menu();
                System.out.println("Invalid option");
        }
    }


}

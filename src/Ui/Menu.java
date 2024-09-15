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
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                break;
            case 2:
//                new Room();
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
        System.out.println("Enter your choice: ");
    }
}

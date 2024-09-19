package Ui;

import java.util.Scanner;

public class Client extends Main {

    public Client() {
        while (true) {
            clear();
            display();
            choice();
        }
    }

    public void display() {
        System.out.println("=== Client Menu ===");
        System.out.println("1. Create a Client");
        System.out.println("2. List all clients");
        System.out.println("3. List professional client");
        System.out.println("4. Get clients by id");
        System.out.println("5. Update client by id");
        System.out.println("6. delete client by id");
        System.out.println("Enter your choice: ");
    }

    public void choice() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                clear();
                new Service.Client().create();
                pause();
                break;
            case 2:
                clear();
                new Service.Client().list();
                pause();
                break;
            case 3:
                clear();
                new Service.Client().filteronlyProfessional();
                pause();
                break;
            case 4:
                clear();
//                new Service.Client().get();
                pause();
                break;
            case 5:
                clear();
                new Service.Client().update();
                pause();
                break;
            case 6:
                clear();
                new Service.Client().delete();
                pause();
                break;

            default:
                new Menu();
                System.out.println("Invalid option");
        }

    }
}

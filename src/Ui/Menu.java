package Ui;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Menu() throws SQLException {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Rooms Menu");
            System.out.println("2. Customers Menu");
            System.out.println("3. Reservations Menu");
            System.out.println("4. Hotels Menu");
            System.out.println("5. Exit");
            Scanner scanner = new Scanner(System.in);

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    new Reservation();
                    break;
                case 2:
                    new Room();
                    break;
                case 3:
                    System.out.println("Update Room");
                    break;
                case 4:
                    System.out.println("Delete Room");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }




    }
}

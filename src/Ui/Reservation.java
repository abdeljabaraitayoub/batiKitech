package Ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    Service.Reservation reservationService = new Service.Reservation();
    public Reservation() throws SQLException {
        while (true) {
            System.out.println("\n--- Reservation Menu ---");
            System.out.println("1. Create Reservation");
            System.out.println("2. Show All Reservations");
            System.out.println("3. Show Reservation By Id");
            System.out.println("4. Update Reservation By Id");
            System.out.println("5. Delete Reservation By Id");
            System.out.println("6. Deleted Reservations");
            System.out.println("7. Show Clients");
            System.out.println("8. Show Rooms");
            System.out.println("9. Reservation statistics");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    save();
                    break;
                case 2:
                    List();
                    break;
                case 3:
                    Get();
                    break;
                case 4:
//                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
//                    findAllDeletedReservations();
                    break;
                case 7:
//                    clientMenu(roomService, clientService, reservationService);
                    break;
                case 8:
//                    roomMenu(roomService, clientService, reservationService);
                    break;
                case 9:
//                    statisticMenu(statisticsService, reservationService, roomService, clientService);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void List() throws SQLException {
        ArrayList<Entitie.Reservation> reservations = reservationService.List();
        for (Entitie.Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public void Get() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter reservation id: ");
        int id = scanner.nextInt();
        Entitie.Reservation reservation = reservationService.Get(id);
        if (reservation != null) {
            System.out.println(reservation);
        } else {
            System.out.println("Reservation not found.");
        }
    }

    public void delete() throws SQLException {
        reservationService.delete();
    }
    public void save() throws SQLException {
            reservationService.save();

    }
}

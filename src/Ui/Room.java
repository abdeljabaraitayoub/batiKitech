package Ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Enum.type;
import Enum.RoomStatus;
public class Room {
    private Service.Room roomService = new Service.Room();
    public Room() throws SQLException {
        while (true) {
            System.out.println("\n--- Room Menu ---");
            System.out.println("1. Create Room");
            System.out.println("2. Show All Rooms");
            System.out.println("3. Show Room By Id");
            System.out.println("4. Update Room By Id");
            System.out.println("5. Delete Room By Id");
            System.out.println("6. Show Available Rooms");
//            System.out.println("7. Show Occupied Rooms");
//            System.out.println("8. Show Maintenance Rooms");
            System.out.println("9. Exit");
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
                    get();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    getAvailableRooms();
                    break;
                case 7:
//                    getOccupiedRooms();
                    break;
                case 8:
//                    getMaintenanceRooms();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    Menu menu = new Menu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void save() throws SQLException {
        roomService.save();
    }

    public void List() throws SQLException {
        List<Entitie.Room> rooms =roomService.List();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found");
        }else {
            for (Entitie.Room room : rooms) {
                System.out.println(room);
            }
        }

    }

    public void get() throws SQLException {
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room id: ");
        id = scanner.nextInt();
        Entitie.Room room = roomService.Get(id);
        if (room != null) {
            System.out.println(room);
        } else {
            System.out.println("Room not found");
        }
    }

    public void delete() throws SQLException {
        List();
        roomService.delete();
        System.out.println("Room deleted successfully");
    }

    public void update() throws SQLException {
        List();
        System.out.println("\n");
        roomService.update();
        System.out.println("Room updated successfully");
    }

    public void getAvailableRooms() throws SQLException {
        List<Entitie.Room> rooms=roomService.getAvailableRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found");
        } else {
            for (Entitie.Room room : rooms) {
                System.out.println(room);
            }
        }
    }
}

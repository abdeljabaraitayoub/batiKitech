package Service;

import Enum.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    private List<Entitie.Room> rooms = new ArrayList<>();

    public List<Entitie.Room> List() throws SQLException {
        return new Repository.Room().List();
    }

    public Entitie.Room Get(int id) throws SQLException {
        return new Repository.Room().Get(id);
    }

    public void save() throws SQLException {
        Entitie.Room room = new Entitie.Room();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room number: ");
        room.setNumber(scanner.nextInt());
        System.out.print("Enter room type: \n");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Suite");
        switch (scanner.nextInt()) {
            case 1:
                room.setType(type.SINGLE);
                break;
            case 2:
                room.setType(type.DOUBLE);
                break;
            case 3:
                room.setType(type.SUITE);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        System.out.print("Enter room status: \n");
        System.out.println("1. AVAILABLE");
        System.out.println("2. OCCUPIED");
        System.out.println("3. MAINTENANCE");
        switch (scanner.nextInt()) {
            case 1:
                room.setStatus(RoomStatus.AVAILABLE);
                break;
            case 2:
                room.setStatus(RoomStatus.OCCUPIED);
                break;
            case 3:
                room.setStatus(RoomStatus.MAINTENANCE);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        System.out.print("Enter room price: ");
        room.setPrice(scanner.nextDouble());
        new Repository.Room().save(room);
    }

    public void delete() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room id: ");
        new Repository.Room().deleteRoom(scanner.nextInt());
    }

    public void update() {
        System.out.println("Enter room id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Entitie.Room room = new Entitie.Room();
        System.out.print("Enter room type: \n");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Suite");
        switch (scanner.nextInt()) {
            case 1:
                room.setType(type.SINGLE);
                break;
            case 2:
                room.setType(type.DOUBLE);
                break;
            case 3:
                room.setType(type.SUITE);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        System.out.print("Enter room status: \n");
        System.out.println("1. AVAILABLE");
        System.out.println("2. OCCUPIED");
        System.out.println("3. MAINTENANCE");
        switch (scanner.nextInt()) {
            case 1:
                room.setStatus(RoomStatus.AVAILABLE);
                break;
            case 2:
                room.setStatus(RoomStatus.OCCUPIED);
                break;
            case 3:
                room.setStatus(RoomStatus.MAINTENANCE);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        System.out.print("Enter room price: ");
        room.setPrice(scanner.nextDouble());
        try {
            new Repository.Room().update(id, room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Entitie.Room> getAvailableRooms() throws SQLException {
        return new Repository.Room().getAvailableRooms();

    }
}

package Entitie;
import Enum.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    private int id;
    private int number;
    private double price;
    private static type type;
    private RoomStatus status;

    public Room() {
    }

    public Room(int number, double price, type type) {
        this.number = number;
        this.price = price;
        this.type = type;
        this.status = RoomStatus.AVAILABLE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "--------------------Room--------------------\n" +
                "Id: " + id + "\n" +
                "Room Number: " + number + "\n" +
                "Room Type: " + type + "\n" +
                "Room Status: " + status + "\n" +
                "Room Price: " + price ;
    }

    public static Room mapResultSet(ResultSet data) throws SQLException {
        Room room = new Room();
        if (data.getInt("id") != 0) {
            room.setId(data.getInt("id"));
            room.setNumber(data.getInt("number"));
            room.setPrice(data.getDouble("price"));
            room.setType(type.valueOf(data.getString("type")));
            room.setStatus(RoomStatus.valueOf(data.getString("status")));
        }
            return room;
    }







}

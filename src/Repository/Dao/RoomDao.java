package Repository.Dao;
import Entitie.Room;
import Enum.RoomStatus;
import Enum.type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao extends Dao {

    public void save(Room room) throws SQLException {
            Database.executeUpdate("INSERT INTO rooms (number, type, status, price) VALUES ('"+room.getNumber()+"', '"+room.getType()+"', '"+room.getStatus()+"', '"+room.getPrice()+"')");

    }

    public void update(int id,Room room) throws SQLException {
            Database.executeUpdate("UPDATE rooms SET type = '"+room.getType()+"', status = '"+room.getStatus()+"', price = '"+room.getPrice()+"' WHERE id = "+id);
    }

    public void deleteRoom(int id) throws SQLException {
            Database.executeUpdate("DELETE FROM rooms WHERE id = "+id);
    }


    public ResultSet Get(int id) throws SQLException {
        return Database.executeQuery("SELECT * FROM rooms WHERE id = "+id);
    }

    public ResultSet List() throws SQLException {
         return Database.executeQuery("SELECT * FROM rooms");
    }

    public ResultSet getAvailableRooms() throws SQLException {
        return  Database.executeQuery("SELECT * FROM rooms WHERE status = 'AVAILABLE'");

    }
}

package Repository;
import Repository.Dao.RoomDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private RoomDao roomDao = new RoomDao();


    public void save(Entitie.Room room) throws SQLException {
        roomDao.save(room);
    }

    public void update(int id, Entitie.Room room) throws SQLException {
        roomDao.update(id, room);
    }

    public void deleteRoom(int id) throws SQLException {
        roomDao.deleteRoom(id);
    }

    public Entitie.Room Get(int id) throws SQLException {
        ResultSet data = roomDao.Get(id);
        if (data.next()){
            return Entitie.Room.mapResultSet(data);
        }else
        {
            return null;
        }
    }

    public List<Entitie.Room> List() throws SQLException {
     ResultSet data = roomDao.List();
        List<Entitie.Room> rooms = new ArrayList<>();
        while (data.next()) {
            Entitie.Room room = Entitie.Room.mapResultSet(data);
            rooms.add(room);
        }
        return rooms;
    }

    public List<Entitie.Room> getAvailableRooms() throws SQLException {
        ResultSet data = roomDao.getAvailableRooms();
        List<Entitie.Room> rooms = new java.util.ArrayList<>();
        while (data.next()) {
            Entitie.Room room = Entitie.Room.mapResultSet(data);
            rooms.add(room);
        }
        return rooms;
    }


}

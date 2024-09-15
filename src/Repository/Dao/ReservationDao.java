package Repository.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDao extends Dao {


    public ResultSet List() throws SQLException {
        return Database.executeQuery("SELECT * FROM reservations");

    }

    public ResultSet Get(int id) throws SQLException {
        return Database.executeQuery("SELECT * FROM reservations WHERE id = "+id);
    }

    public void save(Reservation reservation) throws SQLException {
        Database.executeUpdate("INSERT INTO reservations (room_id, customer_id, check_in, check_out, price) VALUES ('"+reservation.getRoom().getId()+"', '"+reservation.getCustomer()+"', '"+reservation.getCheck_inString()+"', '"+reservation.getCheck_outString()+"', '"+reservation.getPrice()+"')");
    }

    public void update(int id, Reservation reservation) {
//        Database.executeUpdate("UPDATE rooms SET type = '"+room.getType()+"', status = '"+room.getStatus()+"', price = '"+room.getPrice()+"' WHERE id = "+id);
    }

    public void delete(int id) throws SQLException {
        Database.executeUpdate("DELETE FROM reservations WHERE id = "+id);
    }


}

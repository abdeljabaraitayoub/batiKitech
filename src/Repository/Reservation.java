package Repository;

import Repository.Dao.ReservationDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reservation {
    private ReservationDao reservationdao=new ReservationDao();


    public void Save(Entitie.Reservation reservation,int room) throws SQLException {
        Room room1 = new Room();
        Repository.Room roomRepository = new Repository.Room();
        if (roomRepository.Get(room) == null){
            System.out.println("Room not found");
            return;
        }
        reservation.setRoom(roomRepository.Get(room));
        reservation.pricing();
        reservationdao.save(reservation);
    }

    public void update(int id, Entitie.Reservation reservation) throws SQLException {
        reservationdao.update(id,reservation);
    }

    public void delete(int id) throws SQLException {
        reservationdao.delete(id);
    }

    public Entitie.Reservation Get(int id) throws SQLException {
        ResultSet data = reservationdao.Get(id);
        if (data.next()){
            return Entitie.Reservation.mapResultSet(data);
        }else
        {
            return null;
        }
    }

    public ArrayList<Entitie.Reservation> List() throws SQLException {
        ResultSet data = reservationdao.List();
        ArrayList<Entitie.Reservation> reservations = new ArrayList<>();
        while (data.next()) {
            Entitie.Reservation reservation = Entitie.Reservation.mapResultSet(data);
            reservations.add(reservation);
        }
        return reservations;
    }




}

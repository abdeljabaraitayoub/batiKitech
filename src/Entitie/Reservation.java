package Entitie;
import Enum.ReservationStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
    int id;
    Room room;
    int customer;
    Date check_in;
    Date check_out;
    ReservationStatus status;
    Float price;

    public Reservation() {
    }

    public Reservation(Room room, int customer, Date check_in, Date check_out, ReservationStatus status, Float price) {
        this.room = room;
        this.customer = customer;
        this.check_in = check_in;
        this.check_out = check_out;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public String getCheck_inString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(check_in);
    }
    public  void setCheck_in(String check_in) {
        Date check_in1 = new Date();
        check_in1.setTime(Date.parse(check_in));
        if (check_in1.before(new Date())) {
            System.out.println("Invalid date");
            return;
        }
        else {
            this.check_in = check_in1;
        }
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }


    public String getCheck_outString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(check_out);
    }

    public void setCheck_out(String check_out) {
        Date check_out1 = new Date();
        check_out1.setTime(Date.parse(check_out));
        if (check_out1.before(new Date())) {
            System.out.println("Invalid date");
            return;
        }
        else {
            this.check_out = check_out1;
        }
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }
    public static Date parseDate(String date) {
        Date date1 = new Date();
        date1.setTime(Date.parse(date));
        return date1;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static Reservation mapResultSet (ResultSet data) throws SQLException {
        Reservation reservation = new Reservation();
        if (data.getInt("id") != 0) {
            reservation.setId(data.getInt("id"));
            reservation.setCheck_in(data.getDate("check_in"));
            reservation.setCheck_out(data.getDate("check_out"));
            reservation.setPrice(data.getFloat("price"));
        }
            return reservation;
    }

    public  String toString() {
        return "--------------------Reservation--------------------\n" +
                "Id: " + id + "\n" +
                "Check-in: " + check_in + "\n" +
                "Check-out: " + check_out + "\n" +
                "Room: " + room + "\n" +
                "Customer: " + customer + "\n" +
                "Price: " + price;
   }

   public  void pricing() {
      double baseprice=  this.getRoom().getPrice();
       Date checkInDate = this.getCheck_in();
       Map<LocalDate, Double> specialDates = new HashMap<>();
       specialDates.put(LocalDate.of(2024, 12, 31), 1.5);
       specialDates.put(LocalDate.of(2024, 12, 25), 1.3);
       specialDates.put(LocalDate.of(2024, 12, 1), 1.2);
       specialDates.put(LocalDate.of(2024, 11, 28), 1.2);
       specialDates.put(LocalDate.of(2024, 11, 11), 1.2);
         if (specialDates.containsKey(checkInDate)) {
              double multiplier = specialDates.get(checkInDate);
              this.setPrice((float) (baseprice * multiplier));
            }
            else if (checkInDate.getDay() == 5 || checkInDate.getDay() == 6) {
                this.setPrice((float) (baseprice * 1.1));
            }
            else if (checkInDate.getDay() == 0) {
                this.setPrice((float) (baseprice * 1.2));
            }
            else if (checkInDate.getMonth() == 7 || checkInDate.getMonth() == 8) {
                this.setPrice((float) (baseprice * 1.3));
            }
            else {
                this.setPrice((float) baseprice);
         }
   }




    


}

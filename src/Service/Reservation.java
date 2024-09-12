package Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {

    private List<Entitie.Reservation> reservations=new ArrayList<>();

    public ArrayList<Entitie.Reservation> List() throws SQLException {
    return new Repository.Reservation().List();
    }

    public Entitie.Reservation Get(int id) throws SQLException {
        return new Repository.Reservation().Get(id);
    }

    public void save() throws SQLException {
        Entitie.Reservation reservation=new Entitie.Reservation();
        System.out.print("Enter room id: ");
        int room = new Scanner(System.in).nextInt();
        System.out.print("Enter customer id: ");
        int customer = new Scanner(System.in).nextInt();
        reservation.setCustomer(customer);
        System.out.print("Enter check in date: ");
        String check_in = new Scanner(System.in).nextLine();
        reservation.setCheck_in(check_in);
        System.out.print("Enter check out date: ");
        String check_out = new Scanner(System.in).nextLine();
        reservation.setCheck_out(check_out);
        System.out.print("Enter price: ");
        reservation.setPrice(new Scanner(System.in).nextFloat());
        new Repository.Reservation().Save(reservation, room);




    }

    public void update() {
        System.out.println("Reservation update view");
    }

    public void delete() throws SQLException {
        System.out.print("enter the ID: ");
        int id =new Scanner(System.in).nextInt();
        new Repository.Reservation().delete(id);
    }
}

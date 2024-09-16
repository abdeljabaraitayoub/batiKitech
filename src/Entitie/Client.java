package Entitie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private int id = 0;
    private String name;
    private String phone;
    private String address;
    private boolean isProfessional;

    public Client(int id, String name, String phone, String address, boolean isProfessional) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.isProfessional = isProfessional;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }


    public boolean getIsProfessional() {
        return isProfessional;
    }

    public void setIsProfessional(boolean isProfessional) {
        this.isProfessional = isProfessional;
    }


    public static Client mapResultSet(ResultSet data) {
        try {
            int id = data.getInt("id");
            String name = data.getString("name");
            String phone = data.getString("phone");
            String address = data.getString("address");
            boolean isProfessional = data.getBoolean("isProfessional");
            return new Client(id, name, phone, address, isProfessional);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }


    public String toString() {
        String border = "=".repeat(50);
        return border + "\n" +
                "Client ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "address: " + address + "\n" +
                "Phone: " + phone + "\n" +
                "Type: " + (isProfessional ? "Professional" : "Individual") + "\n" +
                border + "\n";
    }


}

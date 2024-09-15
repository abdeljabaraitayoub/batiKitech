package Entitie;

public class Client {
    private int id;
    private String name;
    private String email;
    private String phone;
    private boolean isProfessional;

    public Client(int id, String name, String email, String phone, boolean isProfessional) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public boolean getIsProfessional() {
        return isProfessional;
    }

    public void setIsProfessional(boolean isProfessional) {
        this.isProfessional = isProfessional;
    }



    public String toString() {
        String border = "=".repeat(50);
        return border + "\n" +
                "Client ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Type: " + (isProfessional ? "Professional" : "Individual") + "\n" +
                border;
    }




}

package Entitie;
import Enum.ProjectStatus;

public class Project {

    private int id;
    public String name;
    private double profitMargin;
    private double totalCost;
    private ProjectStatus status;
    private Client client;
    private Quote quote;


    public Project(int id,String name,double profitMargin,double totalCost,ProjectStatus status,Client client,Quote quote){
        this.id=id;
        this.name=name;
        this.profitMargin=profitMargin;
        this.totalCost=totalCost;
        this.status=status;
        this.client=client;
        this.quote=quote;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }



    public double getProfitMargin(){
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin){
        this.profitMargin=profitMargin;
    }


    public double getTotalCost(){
        return totalCost;
    }

    public void setTotalCost(double totalCost){
        this.totalCost=totalCost;
    }


    public ProjectStatus getStatus(){
        return status;
    }

    public void setStatus(ProjectStatus status){
        this.status=status;
    }


    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client=client;
    }



    public Quote getQuote(){
        return quote;
    }

    public void setQuote(Quote quote){
        this.quote=quote;
    }



    public String toString() {
        String border = "=".repeat(50);
        return border + "\n" +
                "Project: " + name + "\n" +
                "Status: " + status + "\n" +
                "Profit Margin: " + (profitMargin * 100) + "%\n" +
                "Total Cost: " + totalCost + "€\n" +
                "Client: " + (client != null ? client.getName() : "Not assigned") + "\n" +
//                "Components: " + (components != null ? components.size() : 0) + "\n" +
                "Quote: " + (quote != null ? "Issued on " + quote.getIssueDate() : "Not created") + "\n" +
                border;
    }


}

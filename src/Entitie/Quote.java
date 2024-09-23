package Entitie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import Enum.ComponentType;


public class Quote {
    private int id;
    private double estimatedAmount;
    private Date issueDate;
    private Date validityDate;
    private boolean isAccepted;
    private final Project project;


    public static void main(String[] args) {
        Quote quote = new Quote(1, 1000, new Date(), new Date(), false, new Repository.Project().get(1).get());
    }


    public Quote(int id, double estimatedAmount, Date issueDate, Date validityDate, boolean isAccepted, Project project) {
        this.id = id;
        if (estimatedAmount == 0) {
            this.estimatedAmount = estimateTotalCost(project);
        } else {
            this.estimatedAmount = estimatedAmount;
        }
        this.issueDate = issueDate;
        this.validityDate = validityDate;
        this.isAccepted = isAccepted;
        this.project = project;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }


    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }


    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }


    public boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }


    public Project getProject() {
        return project;
    }


    public void setProject(Project project) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String toString() {
        return "\n" +
                "project: " + (project != null ? project.getName() : "no project assigned") + "\n" +
                "Quote ID: " + id + "\n" +
                "Estimated Amount: " + estimatedAmount + "€\n" +
                "Issue Date: " + issueDate + "\n" +
                "Validity Date: " + validityDate + "\n" +
                "Status: " + (isAccepted ? "Accepted" : "Pending") + "\n" +
                "is expired :" + (validityDate.before(new Date()) ? "Expired" : "Valid") + "\n";
    }

    public static Quote mapResultSet(ResultSet data) {
        try {
            return new Quote(
                    data.getInt("id"),
                    data.getDouble("estimatedAmount"),
                    data.getDate("issueDate"),
                    data.getDate("validityDate"),
                    data.getBoolean("isAccepted"),
                    new Repository.Project().get(data.getInt("project_id")).orElse(null));
        } catch (SQLException e) {
            System.err.println("Error mapping quote: " + e.getMessage());
            return null;
        }
    }


    public static double estimateTotalCost(Project project) {
        double components = project.estimateComponent();
        double totalMargin = components * project.getProfitMargin();
        double totalCost = components + totalMargin;
        totalCost = project.getClient().getIsProfessional() ? totalCost * 0.9 : totalCost;
        return totalCost;
    }
}

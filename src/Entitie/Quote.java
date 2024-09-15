package Entitie;

import java.util.Date;

public class Quote {
    private int id;
    private double estimatedAmount;
    private Date issueDate;
    private Date validityDate;
    private boolean isAccepted;

    public Quote(int id, double estimatedAmount, Date issueDate, Date validityDate, boolean isAccepted) {
        this.id = id;
        this.estimatedAmount = estimatedAmount;
        this.issueDate = issueDate;
        this.validityDate = validityDate;
        this.isAccepted = isAccepted;
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



    public String toString() {
        String border = "=".repeat(50);
        return border + "\n" +
                "Quote ID: " + id + "\n" +
                "Estimated Amount: " + estimatedAmount + "€\n" +
                "Issue Date: " + issueDate + "\n" +
                "Validity Date: " + validityDate + "\n" +
                "Status: " + (isAccepted ? "Accepted" : "Pending") + "\n" +
                border;
    }
}

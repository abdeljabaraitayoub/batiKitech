package Repository.Dao;

import Database.Database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Quote extends Dao {


    public static void main(String[] args) throws SQLException {
        Quote quote = new Quote();
//        quote.create(new Entitie.Quote(1, 1000, new java.util.Date(), new java.util.Date(), false, new Repository.Project().get(1).get()));
//        quote.list().get().forEach(System.out::println);
//        ResultSet data = quote.get(1).get();
//        data.next();
//        System.out.println(data.getInt("id"));
    }

    public void create(Entitie.Quote quote) {
        String sql = "INSERT INTO quotes (estimatedAmount, issueDate, validityDate, isAccepted, project_id) VALUES (?, ?, ?, ?, ?)";
        try {
            int rowsAffected = database.executeUpdate(sql,
                    quote.getEstimatedAmount(),
                    new Date(quote.getIssueDate().getTime()),
                    new Date(quote.getValidityDate().getTime()),
                    quote.getIsAccepted(),
                    quote.getProject().getId()
            );
            if (rowsAffected > 0) {
                System.out.println("Quote inserted successfully.");
            } else {
                System.out.println("Failed to insert quote.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting quote: " + e.getMessage());
        }
    }


    public void update(int id, Entitie.Quote quote) {
        String sql = "UPDATE quotes SET estimatedAmount = ?, issueDate = ?, validityDate = ?, isAccepted = ?, project_id = ? WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql,
                    quote.getEstimatedAmount(),
                    new Date(quote.getIssueDate().getTime()),
                    new Date(quote.getValidityDate().getTime()),
                    quote.getIsAccepted(),
                    quote.getProject().getId(),
                    id
            );
            if (rowsAffected > 0) {
                System.out.println("Quote updated successfully.");
            } else {
                System.out.println("Failed to update quote.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating quote: " + e.getMessage());
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM quotes WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql, id);
            if (rowsAffected > 0) {
                System.out.println("Quote deleted successfully.");
            } else {
                System.out.println("Failed to delete quote.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting quote: " + e.getMessage());
        }
    }

    public Optional<ResultSet> get(int id) {
        String sql = "SELECT * FROM quotes WHERE id = '" + id + "'";
        try {
            return Optional.of(Database.executeQuery(sql));
        } catch (SQLException e) {
            System.err.println("Error getting quote: " + e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<ResultSet> list() {
        String sql = "SELECT * FROM quotes";
        try {
            return Optional.of(Database.executeQuery(sql));
        } catch (SQLException e) {
            System.err.println("Error listing quotes: " + e.getMessage());
            return null;
        }
    }
}

package Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Quote {
    Repository.Dao.Quote quoteDao = new Repository.Dao.Quote();

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.create(new Entitie.Quote(1, 0, new java.util.Date(), new java.util.Date(), false, new Repository.Project().get(1).get()));
//        quote.list().get().forEach(System.out::println);
//        System.out.println(quote.get(2).get());
//        System.out.println(quote.listByProject(1).get());
    }


    public void create(Entitie.Quote quote) {
        try {
            quoteDao.create(quote);
        } catch (Exception e) {
            System.err.println("Error inserting quote: " + e.getMessage());
        }
    }

    public void update(int id, Entitie.Quote quote) {
        try {
            quoteDao.update(id, quote);
        } catch (Exception e) {
            System.err.println("Error updating quote: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            quoteDao.delete(id);
        } catch (Exception e) {
            System.err.println("Error deleting quote: " + e.getMessage());
        }
    }

    public Optional<List<Entitie.Quote>> list() {
        List<Entitie.Quote> quotes = new ArrayList<>();
        try (ResultSet data = quoteDao.list().get()) {
            while (data.next()) {
                quotes.add(Entitie.Quote.mapResultSet(data));
            }
            return Optional.of(quotes);
        } catch (SQLException e) {
            System.err.println("Error listing quotes: " + e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<Entitie.Quote> get(int id) {
        try (ResultSet data = quoteDao.get(id).get()) {
            if (data.next()) {
                return Optional.ofNullable(Entitie.Quote.mapResultSet(data));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            System.err.println("Error getting quote: " + e.getMessage());
            return Optional.empty();
        }
    }


    public Optional<List<Entitie.Quote>> listByProject(int project_id) {
        return Optional.ofNullable(new Quote().list().get().stream().filter(quote -> quote.getProject().getId() == project_id).toList());
    }
}

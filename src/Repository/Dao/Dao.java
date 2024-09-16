package Repository.Dao;

import Database.Database;

public class Dao {
    protected final Database database = Database.getInstance();

    protected String escapeSQL(String str) {
        if (str == null) {
            return "NULL";
        }
        return str.replace("'", "''");
    }
}

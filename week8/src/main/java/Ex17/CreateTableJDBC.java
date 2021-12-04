package Ex17;

import org.h2.Driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CreateTableJDBC {
    static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/test/test";
    static final String JDBC_DRIVER = "org.h2.Driver";

    static final String USER = "sa";
    static final String PASSWORD = "sa";

    public static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()){
            String SQL = "CREATE TABLE \"ORDER\"" +
                    "(NUMBER INT, " +
                    "LOGIN VARCHAR(255), " +
                    "ARTICLE VARCHAR(255));\n" +
                    "CREATE TABLE \"ITEM\"" +
                    "(ARTICLE VARCHAR(255) PRIMARY KEY, " +
                    "NAME VARCHAR(255), " +
                    "PRICE INTEGER);";
            statement.execute(SQL);
        }
    }

    public static void update(Connection connection, String tableName, String atributes, String first, String second, String third) throws SQLException {
        try (Statement statement = connection.createStatement()){
            String SQL = "INSERT INTO " + tableName + atributes + " VALUES" +
                    "(" + first + ", " + second + ", " + third + ");";
            statement.execute(SQL);
        }
    }

    public static boolean hasArticle(Connection connection, String article) throws SQLException {
        String SQL = "SELECT * FROM ITEM " +
                "WHERE ARTICLE = " + article + ";";
        try (Statement statement = connection.createStatement()){
            try (ResultSet result = statement.executeQuery(SQL)) {
                if (result.next()) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
    }

    public static void initializationTable(String pathCSV, Connection connection) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new FileReader(pathCSV));
        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            update(connection, "\"ORDER\"", " (NUMBER, LOGIN, ARTICLE)", fields[0], "'" + fields[1] + "'","'" +  fields[2] + "'");
            if(!hasArticle(connection, "'" + fields[2] + "'")) {
                update(connection, "ITEM",  " (ARTICLE, NAME, PRICE)", "'" + fields[2] + "'","'" +  fields[3] + "'", fields[4]);
            }
            line = reader.readLine();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        //Driver driver = new org.h2.Driver();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)){
            createTables(connection);
            initializationTable(args[0], connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

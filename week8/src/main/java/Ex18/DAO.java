package Ex18;

import Ex18.entities.Item;
import Ex18.entities.Order;
import Ex18.exceptions.IllegalItemException;

import java.sql.*;
import java.util.List;

public class DAO {
    private Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    Item findItem(String article) throws SQLException {
        String SQL = "SELECT * FROM " + Item.class.getSimpleName() +
                " WHERE ARTICLE = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1,  article);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    String articleItem = result.getString("ARTICLE");
                    String nameItem = result.getString("NAME");
                    int priceItem = result.getInt("PRICE");
                    return new Item(articleItem, nameItem, priceItem);
                }
                else {
                    return null;
                }
            }
        }
    }

    Item createItem(Item item) throws IllegalItemException, SQLException {
        if(this.findItem(item.getArticle()) != null)
            throw new IllegalItemException(item);
        String SQL = "INSERT INTO " + Item.class.getSimpleName() +"(ARTICLE, NAME, PRICE) VALUES" +
                "('" + item.getArticle() + "', '" + item.getName() + "', " + item.getPrice() + ");";
        try (Statement statement = connection.createStatement()){
            statement.execute(SQL);
        }
        return item;
    }

    Item updateItem(Item item) throws SQLException, IllegalItemException {
        if(this.findItem(item.getArticle()) == null) {
            return createItem(item);
        }
        String SQL = "UPDATE " + Item.class.getSimpleName() +" SET NAME = '" + item.getName() +
                "', PRICE = " + item.getPrice() + " WHERE ARTICLE = '" + item.getArticle() + "';";
        try (Statement statement = connection.createStatement()){
            statement.execute(SQL);
        }
        return item;
    }

    void deleteItem(String article) throws SQLException {
        String SQL_ORDER = "UPDATE " + "\"" + "ORDER" + "\"" +
                "SET ARTICLE = " + null +
                " WHERE ARTICLE = '" + article + "';";
        try (Statement statement = connection.createStatement()){
            statement.execute(SQL_ORDER);
        }
        String SQL_ITEM = "DELETE " + Item.class.getSimpleName() +
                " WHERE ARTICLE = '" + article + "';";
        try (Statement statement = connection.createStatement()){
            statement.execute(SQL_ITEM);
        }
    }

    Order createOrder(String userLogin, List<Item> items) throws SQLException {
        String SQL_MAXN = "SELECT MAX(NUMBER)" +
        "FROM " + "\"" + "ORDER" + "\"";
        int number = 0;
        try (Statement statement = connection.createStatement()){
            try (ResultSet result = statement.executeQuery(SQL_MAXN)) {
                if (result.next()) {
                    number = result.getInt("MAX(NUMBER)") + 1;
                }
                else {
                    number = 1;
                }
            }
        }
        String SQL_ITEM = "INSERT INTO " + "\"" + "ORDER" + "\"" +"(NUMBER, LOGIN, ARTICLE) VALUES" +
                "(" + number + ", '" + userLogin +"', ?);";
        for (Item item: items) {
            try (PreparedStatement statement = connection.prepareStatement(SQL_ITEM)) {
                statement.setString(1, "" + item.getArticle() + "");
                statement.executeUpdate();
            }
        }
        return new Order(number, userLogin, items);
    }
}

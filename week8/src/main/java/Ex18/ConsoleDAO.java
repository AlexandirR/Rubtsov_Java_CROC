package Ex18;

import org.h2.Driver;
import Ex18.entities.Item;
import Ex18.exceptions.IllegalItemException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleDAO {
    static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/test/test";
    static final String JDBC_DRIVER = "org.h2.Driver";

    static final String USER = "sa";
    static final String PASSWORD = "sa";

    public static void executes(DAO dao, String execute) throws SQLException {
        String[] words = execute.split(" ");
        switch (words[0]) {
            case "ТОВАР":
                try {
                    dao.createItem(new Item(words[1], words[2], Integer.parseInt(words[3])));
                } catch (IllegalItemException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "ИЗМЕНИТЬ":
                try {
                    dao.updateItem(new Item(words[1], words[2], Integer.parseInt(words[3])));
                } catch (IllegalItemException e) {
                    e.printStackTrace();
                }
                break;
            case "УДАЛИТЬ":
                dao.deleteItem(words[1]);
                break;
            case "ЗАКАЗ":
                List<Item> items = new ArrayList<>();
                for (int i = 2; i < words.length; ++i) {
                    Item item = dao.findItem(words[i]);
                    if (item == null) {
                        System.out.println("Нет такого товара для добавления в заказ, article - " + words[i]);
                    }
                    items.add(item);
                }
                dao.createOrder(words[1], items);
                break;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        //Driver driver = new org.h2.Driver();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            DAO dao = new DAO(connection);
            Scanner scanner = new Scanner(System.in);
            String execute = scanner.nextLine();
            while (!execute.equals("КОНЕЦ")) {
                executes(dao, execute);
                execute = scanner.nextLine();
            }
        } catch(SQLException throwables){
                throwables.printStackTrace();
        }
    }
}
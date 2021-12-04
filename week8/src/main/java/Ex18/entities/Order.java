package Ex18.entities;

import java.util.List;

public class Order {
    private int number;
    private String login;
    private List<Item> articles;

    public Order(int number, String login, List<Item> articles) {
        this.number = number;
        this.login = login;
        this.articles = articles;
    }
}

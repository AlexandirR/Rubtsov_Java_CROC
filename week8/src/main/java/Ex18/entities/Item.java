package Ex18.entities;

public class Item {
    private String article;
    private String name;
    private int price;

    public Item(String article, String name, int price) {
        this.article = article;
        this.name = name;
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return article + " - " + name + " - " + price;
    }
}

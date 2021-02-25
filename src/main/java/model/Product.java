package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int quantity;
    private String color;
    private String category;

    public Product() {
    }

    public Product(String name, float price, int quantity, String color, String category) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(int id, String name, float price, int quantity, String color, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getCategory() {
        return category;
    }
}

package models;

public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private int category_id;
    private String category_name;

    public Product() {
    }

    //Used for POST requests
    public Product(String name, String description, double price, int category_id) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);
    }

    //Used for GET requests
    public Product(int id, String name, String description, double price, int category_id, String category_name) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);
        setCategory_name(category_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}

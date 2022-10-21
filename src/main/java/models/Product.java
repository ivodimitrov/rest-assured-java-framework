package models;

public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private String categoryName;

    public Product() {
    }

    //Used for POST requests
    public Product(String name, String description, double price, int categoryId) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategoryId(categoryId);
    }

    //Used for GET requests
    public Product(int id, String name, String description, double price, int categoryId, String categoryName) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategoryId(categoryId);
        setCategoryName(categoryName);
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

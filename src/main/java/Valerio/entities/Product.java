package Valerio.entities;

import java.util.List;
import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;
Random random = new Random();
    public Product(String name, String category, double price){
        this.id = random.nextLong(1, 10000000000L);
        this.name = name;
        this.category = category;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {

        return category;
    }

    public void setPrice(double price){

        this.price = price;
    }

    public List<Product> sameCategory(List<Product> products){
        return products.stream().filter(p -> p.getCategory().equals("books") && (p.getPrice()>100)).toList();
    }
    public List<Product> searchCategoryByBoys(List<Product> products){
        return products.stream().filter(p -> p.getCategory().equals("boys")).toList();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

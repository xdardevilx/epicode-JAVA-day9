package Valerio.entities;

;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private String status;
    private Date orderDate;
    private Date deliveryDate;
    private List<Product> products;
    private Customer customer;

    Random random = new Random();
    public Order (String status, Date orderDate, List<Product> products, Customer customer){
        this.id = random.nextLong(1, 10000000000L);
        this.status = status;
        this.orderDate = orderDate;
        this.products = products;
        this.customer = customer;
        this.deliveryDate = Date.from(orderDate.toInstant().plus(10, java.time.temporal.ChronoUnit.DAYS));

    }

    public String getStatus() {
        return status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts(){
        return this.products;
    }

    public void filterOrderBaby(List<Product> products){
        products.stream().filter(p -> p.getCategory().equals("baby")).forEach(product ->{
            System.out.println(product.getName() + " - " + " - " + product.getCategory() +  " - " + product.getPrice());
        });

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}

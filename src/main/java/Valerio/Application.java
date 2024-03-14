package Valerio;
import Valerio.entities.Customer;
import Valerio.entities.Order;
import Valerio.entities.Product;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) {


        Faker fake = new Faker();
        Random random = new Random();


        List<Product> products = new ArrayList <>();
        Supplier<Product> productSupplier = ()-> new Product(fake.harryPotter().book(), "book", random.nextInt(11, 20));
        Supplier<Product> productSupplier1 = ()-> new Product(fake.animal().name(), "animal", random.nextInt(11, 20));
        Supplier<Product> productSupplier2 = ()-> new Product(fake.artist().name(), "artist", random.nextInt(11, 20));

        List <Customer> customers = new ArrayList <>();
        Supplier <Customer> customerSupplier = () -> new Customer(fake.dragonBall().character(), random.nextInt(1, 10));


        //creo la lista di clienti con 5 clienti e una lista di prodotti
        int count = 0;
        while( count < 5){
            customers.add(customerSupplier.get());
            products.add(productSupplier.get());
            products.add(productSupplier1.get());
            products.add(productSupplier2.get());
            count++;
        }
        //creo l'ordine con una lista di prodotti e un cliente random
        List<Order> orders = new ArrayList <>();
        Order order = new Order("in consegna", fake.date().birthday(0, 30), products, customers.get(random.nextInt(0, customers.size())));
        Order order1 = new Order("pending", fake.date().birthday(0, 30), products, customers.get(random.nextInt(0, customers.size())));
        Order order2 = new Order("consegnato", fake.date().birthday(0, 30), products, customers.get(random.nextInt(0, customers.size())));
        orders.add(order);
        orders.add(order1);
        orders.add(order2);

        // ordino la lista con map

        Map<String, List<Order>> ordersByCustomer = orders.stream().collect(Collectors.groupingBy(Order -> Order.getCustomer().getName()));


        ordersByCustomer.forEach((customer , ordersList) -> {
            System.out.println("Customer: " + customer + " - " + "Orders: " + orders.size());
           ordersList.forEach(ordine ->{
              System.out.println("Order: " + ordine.getProducts());
           });


        });

        }
    }




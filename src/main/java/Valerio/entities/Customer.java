package Valerio.entities;

import java.util.Random;

public class Customer {
    private long id;
    private String name;
    private int tier;

Random random = new Random();
    public Customer(String name, int tier) {
        this.id = random.nextLong(1, 10000000000L);

        this.name = name;
        this.tier = tier;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Valerio.entities.Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier='" + tier + '\'' +
                '}';
    }

}

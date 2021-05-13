package org.learning.komissarov;

public class Product {

    private final int id;
    private final String title;
    private final double cost;

    public Product(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost;
    }
}

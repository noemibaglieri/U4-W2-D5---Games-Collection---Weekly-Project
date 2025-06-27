package noemibaglieri.entities;

import java.util.Random;

public abstract class Game {
    protected int id;
    protected String title;
    protected int yearOfPublication;
    protected double price;

    protected Game(int id, String title, int yearOfPublication, double price) {
        this.id = id;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

}

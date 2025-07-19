package entities;

import enums.laundryServices;

public class Product {


    private static int counter = 0;

    private Integer id;
    private String parType; // tipo de peça
    private String color; // cor
    private String mark; // marca

    public Product(String mark, String color, String parType) {
        this.mark = mark;
        this.color = color;
        this.parType = parType;
        this.id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Product.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParType() {
        return parType;
    }

    public void setParType(String parType) {
        this.parType = parType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}

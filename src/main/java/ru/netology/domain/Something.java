package ru.netology.domain;

public class Something extends Product {
    private String text;

    public Something(int id, String name, int price, String text) {
        super(id, name, price);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

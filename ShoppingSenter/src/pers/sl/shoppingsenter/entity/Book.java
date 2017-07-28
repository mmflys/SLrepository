package pers.sl.shoppingsenter.entity;

import java.math.BigDecimal;

public class Book {
    int book_id;
    String book_name;
    BigDecimal price;
    int book_balance;
    int book_power;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getBook_balance() {
        return book_balance;
    }

    public void setBook_balance(int book_balance) {
        this.book_balance = book_balance;
    }

    public int getBook_power() {
        return book_power;
    }

    public void setBook_power(int book_power) {
        this.book_power = book_power;
    }

    @Override
    public String toString() {
        return "Book [book_id=" + book_id + ", book_name=" + book_name
                + ", price=" + price + ", book_balance=" + book_balance
                + ", book_power=" + book_power + "]";
    }

}

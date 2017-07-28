package pers.sl.shoppingsenter.entity;

import java.sql.Date;

public class BookOrder {
    int book_order_id;
    int user_id;
    int book_id;
    Date book_order_date;
    int book_order_power;

    public int getBook_order_id() {
        return book_order_id;
    }

    public void setBook_order_id(int book_order_id) {
        this.book_order_id = book_order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Date getBook_order_date() {
        return book_order_date;
    }

    public void setBook_order_date(Date book_order_date) {
        this.book_order_date = book_order_date;
    }

    public int getBook_order_power() {
        return book_order_power;
    }

    public void setBook_order_power(int book_order_power) {
        this.book_order_power = book_order_power;
    }

    @Override
    public String toString() {
        return "BookOrder [book_order_id=" + book_order_id + ", user_id="
                + user_id + ", book_id=" + book_id + ", book_order_date="
                + book_order_date + ", book_order_power=" + book_order_power
                + "]";
    }

}

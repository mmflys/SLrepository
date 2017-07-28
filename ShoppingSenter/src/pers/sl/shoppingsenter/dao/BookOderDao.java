package pers.sl.shoppingsenter.dao;

import java.util.List;

import pers.sl.shoppingsenter.entity.BookOrder;

public interface BookOderDao {
    // 获取单个订单
    BookOrder getBookOderById(int bookOrder_id);

    // 获取所有订单
    List<BookOrder> listBookOrder();

    // 新建订单
    void saveBookOrder(BookOrder bookOrder);

    // 更新订单
    void updateBookOrder(BookOrder bookOrder);

    // 删除订单
    void deleteBookOder(int book_order_id);
}

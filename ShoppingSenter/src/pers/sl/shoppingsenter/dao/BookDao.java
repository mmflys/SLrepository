package pers.sl.shoppingsenter.dao;

import java.util.List;

import pers.sl.shoppingsenter.entity.Book;

public interface BookDao {
    // 根据id获取商品
    Book getBookById(int book_id);

    // 获取所有商品
    List<Book> listBook();

    // 新建商品
    void saveBook(Book Book);

    // 更新商品
    void updateBook(Book book);

    // 删除用户
    void deleteBook(int book_id);
}

package pers.sl.shoppingsenter.dao;

import java.util.List;

import pers.sl.shoppingsenter.entity.BookOrder;

public interface BookOderDao {
    // ��ȡ��������
    BookOrder getBookOderById(int bookOrder_id);

    // ��ȡ���ж���
    List<BookOrder> listBookOrder();

    // �½�����
    void saveBookOrder(BookOrder bookOrder);

    // ���¶���
    void updateBookOrder(BookOrder bookOrder);

    // ɾ������
    void deleteBookOder(int book_order_id);
}

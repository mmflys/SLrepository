package pers.sl.shoppingsenter.service;

import java.util.List;

import pers.sl.shoppingsenter.entity.BookOrder;

public interface BookOrderService {
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

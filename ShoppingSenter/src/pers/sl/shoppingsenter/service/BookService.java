package pers.sl.shoppingsenter.service;

import java.util.List;

import pers.sl.shoppingsenter.entity.Book;

public interface BookService {
    // ����id��ȡ��Ʒ
    Book getBookById(int book_id);

    // ��ȡ������Ʒ
    List<Book> listBook();

    // �½���Ʒ
    void saveBook(Book Book);

    // ������Ʒ
    void updateBook(Book book);

    // ɾ���û�
    void deleteBook(int book_id);
}

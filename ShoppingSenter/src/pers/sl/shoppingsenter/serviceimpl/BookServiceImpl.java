package pers.sl.shoppingsenter.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sl.shoppingsenter.dao.BookDao;
import pers.sl.shoppingsenter.entity.Book;
import pers.sl.shoppingsenter.service.BookService;

@Service(value = "BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Book getBookById(int book_id) {
        return bookDao.getBookById(book_id);
    }

    @Override
    public List<Book> listBook() {
        return bookDao.listBook();
    }

    @Override
    public void saveBook(Book Book) {
        bookDao.saveBook(Book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(int book_id) {
        bookDao.deleteBook(book_id);
    }

}

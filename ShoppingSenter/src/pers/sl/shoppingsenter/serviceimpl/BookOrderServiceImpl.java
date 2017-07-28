package pers.sl.shoppingsenter.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sl.shoppingsenter.dao.BookOderDao;
import pers.sl.shoppingsenter.entity.BookOrder;
import pers.sl.shoppingsenter.service.BookOrderService;

@Service(value = "BookOrderService")
public class BookOrderServiceImpl implements BookOrderService {

    @Autowired
    BookOderDao bookOrderDao;

    @Override
    public BookOrder getBookOderById(int bookOrder_id) {
        return bookOrderDao.getBookOderById(bookOrder_id);
    }

    @Override
    public List<BookOrder> listBookOrder() {
        return bookOrderDao.listBookOrder();
    }

    @Override
    public void saveBookOrder(BookOrder bookOrder) {
        bookOrderDao.saveBookOrder(bookOrder);
    }

    @Override
    public void updateBookOrder(BookOrder bookOrder) {
        bookOrderDao.updateBookOrder(bookOrder);
    }

    @Override
    public void deleteBookOder(int book_order_id) {
        bookOrderDao.deleteBookOder(book_order_id);
    }

}

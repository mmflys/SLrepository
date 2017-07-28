package pers.sl.shoppingsenter.mapper;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import pers.sl.shoppingsenter.dao.BookOderDao;
import pers.sl.shoppingsenter.entity.BookOrder;

public class BookOrderMapper extends JdbcDaoSupport implements BookOderDao {

    @Override
    public BookOrder getBookOderById(int bookOrder_id) {
        String sql = "select * from fun_book_order where book_order_id=?";
        return super.getJdbcTemplate().queryForObject(sql,
                ParameterizedBeanPropertyRowMapper.newInstance(BookOrder.class),
                bookOrder_id);
    }

    @Override
    public List<BookOrder> listBookOrder() {
        String sql = "select * from fun_book_order";
        return super.getJdbcTemplate().query(sql,
                ParameterizedBeanPropertyRowMapper
                        .newInstance(BookOrder.class));
    }

    @Override
    public void saveBookOrder(BookOrder bookOrder) {
        String sql = "insert into fun_book_order values(null, ?, ?, ?, ?)";
        super.getJdbcTemplate().update(sql, bookOrder.getUser_id(),
                bookOrder.getBook_id(), bookOrder.getBook_order_date(),
                bookOrder.getBook_order_power());
    }

    @Override
    public void updateBookOrder(BookOrder bookOrder) {
        String sql = "update fun_book_order set user_id=?, book_id=?, book_order_date=?, book_order_power=? "
                + "where book_order_id=?";
        super.getJdbcTemplate().update(sql, bookOrder.getUser_id(),
                bookOrder.getBook_id(), bookOrder.getBook_order_date(),
                bookOrder.getBook_order_power(), bookOrder.getBook_order_id());
    }

    @Override
    public void deleteBookOder(int book_order_id) {
        String sql = "update fun_book_order set book_order_power=? where book_order_id=? ";
        super.getJdbcTemplate().update(sql, 0, book_order_id);
    }

}

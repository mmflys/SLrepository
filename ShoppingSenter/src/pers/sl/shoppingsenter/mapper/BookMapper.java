package pers.sl.shoppingsenter.mapper;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import pers.sl.shoppingsenter.dao.BookDao;
import pers.sl.shoppingsenter.entity.Book;

public class BookMapper extends JdbcDaoSupport implements BookDao {

    @Override
    public Book getBookById(int book_id) {
        String sql = "select * from com_book where book_id=?";
        return super.getJdbcTemplate().queryForObject(sql,
                ParameterizedBeanPropertyRowMapper.newInstance(Book.class),
                book_id);
    }

    @Override
    public List<Book> listBook() {
        String sql = "select * from com_book";
        return super.getJdbcTemplate().query(sql,
                ParameterizedBeanPropertyRowMapper.newInstance(Book.class));
    }

    @Override
    public void saveBook(Book book) {
        String sql = "insert into com_book values(null,?,?,?,?)";
        super.getJdbcTemplate().update(sql, book.getBook_name(),
                book.getPrice(), book.getBook_balance(), book.getBook_power());
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update com_book set book_name=?, book_price=?, book_balance=?, book_power=? where book_id=?";
        super.getJdbcTemplate().update(sql, book.getBook_name(),
                book.getPrice(), book.getBook_balance(), book.getBook_power(),
                book.getBook_id());
    }

    @Override
    public void deleteBook(int book_id) {
        String sql = "update com_book set book_power=? where book_id=?";
        super.getJdbcTemplate().update(sql, 0, book_id);
    }

}

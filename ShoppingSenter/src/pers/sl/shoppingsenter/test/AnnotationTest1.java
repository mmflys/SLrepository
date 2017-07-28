package pers.sl.shoppingsenter.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pers.sl.shoppingsenter.entity.BookOrder;
import pers.sl.shoppingsenter.service.BookOrderService;
import pers.sl.shoppingsenter.service.BookService;
import pers.sl.shoppingsenter.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AnnotationTest1 {

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;
    @Autowired
    BookOrderService bookOrderService;

    @Test
    public void Test1() {
        // System.out.println(userService.listUser());
        // System.out.println(userService.getUserById(1));
        // User user = new User();
        // user.setUser_name("yubaibai");
        // user.setUser_password("123");
        // user.setUser_score(50);
        // user.setUser_power(1);
        // userService.updateUser(user);
        // userService.saveUser(user);
        // userService.deleteUser(4);
        // System.out.println(userService.getUserById(4));
        //
        // System.out.println(bookService.listBook());
        // Book book = new Book();
        // book.setBook_id(4);
        // book.setBook_name("英语1");
        // BigDecimal price = new BigDecimal(11.2);
        // book.setPrice(price);
        // book.setBook_balance(10);
        // book.setBook_power(1);
        // bookService.updateBook(book);
        // bookService.deleteBook(4);
        // System.out.println(bookService.getBookById(4));

        System.out.println(bookOrderService.listBookOrder());
        BookOrder bookOrder = new BookOrder();
        bookOrder.setBook_order_id(4);
        bookOrder.setBook_id(5);
        bookOrder.setUser_id(6);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(date);
        System.out.println("格式化后的日期：" + dateNowStr);
        java.sql.Date dateReal = new java.sql.Date(Long.valueOf(dateNowStr));

        bookOrder.setBook_order_date(dateReal);
        bookOrder.setBook_order_power(1);
        bookOrderService.updateBookOrder(bookOrder);
        System.out.println(bookOrderService.getBookOderById(4));
    }
}

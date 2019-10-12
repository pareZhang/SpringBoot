package com.zjm;

import com.zjm.bean.Book;
import com.zjm.repository.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    public void contextLoads() {
        bookDao.getBookById(1);
        bookDao.getBookById(1);
        bookDao.deleteBookById(1);
        Book b1 = bookDao.getBookById(1);
        System.out.println("b1:" + b1);
        Book b = new Book();
        b.setName("三国演义");
        b.setAuthor("罗贯中");
        b.setId(1);
        bookDao.updateBookById(b);
        Book b2 = bookDao.getBookById(1);
        System.out.println("b2:" + b2);
    }

}

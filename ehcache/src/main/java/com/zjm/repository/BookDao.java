package com.zjm.repository;

import com.zjm.bean.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "book_cache") //指明使用的缓存的名字
public class BookDao {
    @Cacheable //表示对该方法进行缓存，
              // 默认情况下 缓存的key是方法的参数,value是方法的返回值
    public Book getBookById(Integer id){
        System.out.println("getBookById");
        Book book=new Book();
        book.setId(id);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        return book;
    }
    @CachePut(key = "#book.id")
    public Book updateBookById(Book book){
        System.out.println("updateBookById");
        book.setName("三国演义2");
        return book;
    }
    @CacheEvict(key = "#id")
    public void deleteBookById(Integer id){
        System.out.println("deleteBookById");
    }
}

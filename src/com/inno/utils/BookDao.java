package com.inno.utils;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.helper.DAOBase;
import com.inno.bean.Book;

public class BookDao extends DAOBase {

    static {
        ObjectifyService.register(Book.class);
    }

    public Book save(Book book) {
        ofy().put(book);
        return book;
    }
    
    public Book findById(Long bId) {
        Key<Book> key = new Key<Book>(Book.class, bId);
        return ofy().get(key);
    }
}
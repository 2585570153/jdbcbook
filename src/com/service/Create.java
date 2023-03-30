package com.service;

import com.dao.ListBook;
import com.dao.Listlog;

/**
 * @author : ad
 **/

public class Create {
    public Create(String bookname, String author, String print, String date,String state,int count) {
        ListBook.create(bookname,author,print,date,state,count);
        Listlog.create(bookname);

    }
}

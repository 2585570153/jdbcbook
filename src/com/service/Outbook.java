package com.service;

import com.dao.ListBook;

/**
 * @author : ad
 * @date : 2023-03-16 16:22
 **/
public class Outbook {
    public Outbook(String outbookname) {
        ListBook.ifoutbook(outbookname);
    }

}

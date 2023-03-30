package com.service;

import com.dao.ListBook;
import com.dao.Listlog;

/**
 * @author : ad
 * @date : 2023-03-16 17:17
 **/
public class Inbook {
    public Inbook(String inname) {
        ListBook.ifinbook(inname);
    }

}

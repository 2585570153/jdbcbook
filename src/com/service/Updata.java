package com.service;

import com.dao.ListBook;

/**
 * @author : ad
 **/
public class Updata {
    public static void upbookname(int id,String upbookname){
        ListBook.upbookname(id, upbookname);
    }
    public static void updauthor(int id,String upauthor){
        ListBook.upauthor(id, upauthor);

    }
    public static void upprint(int id,String upprint){
        ListBook.upprint(id, upprint);

    }
    public static void updata(int id,String updata){
        ListBook.updata(id, updata);
    }
}

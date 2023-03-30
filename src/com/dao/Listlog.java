package com.dao;

import java.util.ArrayList;

/**
 * @author : ad
 * @date : 2023-03-16 18:05
 **/
public class Listlog {
    static ArrayList<Log> logbook = new ArrayList<Log>();
    public static void forlog(){
        System.out.println("以下是用户的操作日志");
        for (Log logbook:logbook){
            System.out.println(logbook.toString());
        }
    }
    public static void create(String name){
        Log logcreate = new Log();
        logcreate.createname(name);
        logcreate.data();
        logbook.add(logcreate);
    }
    public static void delete(String name){
        Log logcreate = new Log();
        logcreate.deletename(name);
        logcreate.data();
        logbook.add(logcreate);
    }
    public static void inbook(String name){
        Log logcreate = new Log();
        logcreate.inbookname(name);
        logcreate.data();
        logbook.add(logcreate);
    }
    public static void outbook(String name){
        Log logcreate = new Log();
        logcreate.outbookname(name);
        logcreate.data();
        logbook.add(logcreate);
    }
    public static void updata(String name){
        Log logcreate = new Log();
        logcreate.updataname(name);
        logcreate.data();
        logbook.add(logcreate);
    }
}

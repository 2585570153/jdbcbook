package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author : ad
 * @date : 2023-03-16 17:33
 **/
public class Log {
    public String log="用户admin";
    public String logname;
    public String logdata;

    public void data(){
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.logdata=ft.format(d);
    }
    public void createname(String name){
        this.logname="加入"+"《"+name+"》";
    }
    public void deletename(String name){
        this.logname="下架"+"《"+name+"》";
    }
    public void inbookname(String name){
        this.logname="还入"+"《"+name+"》";
    }
    public void outbookname(String name){
        this.logname="借出"+"《"+name+"》";
    }
    public void updataname(String name){
        this.logname="修改"+"《"+name+"》";
    }

    @Override
    public String toString() {
        return logdata+"\t"+log + logname ;
    }
}

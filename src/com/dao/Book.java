package com.dao;

import java.util.Date;


public class Book {

    private String bookname;
    private String author;
    private String print;
    private String pubDate;

    private String state;
    private int count;
    private int id;


    public Book(int id,String bookname, String author, String print, String date,String state,int count) {
        this.bookname = bookname;
        this.author = author;
        this.print = print;
        this.pubDate = date;
        this.id=id;
        this.count=count;
        this.state=state;
    }


    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubDate() {
        return pubDate;
    }

    @Override
    public String toString() {
        return  id+"\t"+"书名：《" + bookname +"》"+"\t"+ "作者：" + author +"\t"+  "出版社：" + print+"\t" +  "出版日期" + pubDate+"\t"+"库存："+state+"\t"+"借阅次数：" + count;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrint(String print) {
        this.print = print;
    }



    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrint() {
        return print;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int i) {
        this.count += i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

package com.dao;

import java.sql.*;
import java.util.ArrayList;
/**
 * @author : ad
 **/

public class ListBook {


    static ArrayList<Book> listbook = new ArrayList<Book>();

    public static void read() throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/book";
        String username = "root";
        String password = "root";

        // 1. 加载 JDBC 驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取数据库连接对象
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 创建 Statement 对象
        Statement stmt = conn.createStatement();

        // 4. 执行 SQL 查询语句
        String sql = "SELECT * FROM book";
        ResultSet rs = stmt.executeQuery(sql);

        // 5. 处理查询结果集
        while (rs.next()) {
            Book book = new Book(rs.getInt("id"),rs.getString("bookname"),rs.getString("author"),rs.getString("print"), rs.getString("pubdata"),rs.getString("state"),rs.getInt("count"));
            listbook.add(book);
        }

        rs.close();
        stmt.close();
        conn.close();

        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
    public static void forbook(){
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
    // 删除
    public static void delete(int i){
        if(i-1<=listbook.size()){
            Book deletebook =listbook.get(i-1);
            String temp="不足";
            if (!temp.equals(deletebook.getState())){
                Listlog.delete(deletebook.getBookname());
                listbook.remove(i-1);
                System.out.println("删除成功");
                for (int j= 0;j<listbook.size();j++){
                    Book book = listbook.get(j);
                    book.setId(j+1);
                }
                for (Book book : listbook) {
                    String string = book.toString();
                    System.out.println(string);
                }
            }else {
                System.out.println("删除失败,本书没有归还");
            }

        }else {
            System.out.println("删除失败");
        }
    }
    // 添加
    public static void create(String bookname, String author, String print, String date,String state,int count) {
        int temp = 0;
        for (Book book : listbook) {
            String string = book.getBookname();
            if (string.equals(bookname)) {
                System.out.println("图书中已有本书，不需要再添加");
                temp = 1;
            }
        }
        if (temp == 0) {
            listbook.add(new Book(1 + listbook.size(), bookname, author, print, date, state, count));
            System.out.println("添加成功");
            for (Book book1 : listbook) {
                String string1 = book1.toString();
                System.out.println(string1);
            }

        }
    }

//修改图书
        public static void upauthor ( int id, String upauthor){
            Book upbook = listbook.get(id - 1);
            upbook.setAuthor(upauthor);
            listbook.set(id - 1, upbook);
            System.out.println("修改成功");
            Book deletebook = listbook.get(id - 1);
            Listlog.updata(deletebook.getBookname());
            for (Book book : listbook) {
                String string = book.toString();
                System.out.println(string);
            }
        }
        //修改图书
        public static void upprint ( int id, String upprint){
            Book upbook = listbook.get(id - 1);
            upbook.setPrint(upprint);
            listbook.set(id - 1, upbook);
            System.out.println("修改成功");
            Book deletebook = listbook.get(id - 1);
            Listlog.updata(deletebook.getBookname());
            for (Book book : listbook) {
                String string = book.toString();
                System.out.println(string);
            }
        }
        //修改图书
        public static void updata ( int id, String updata){
            Book upbook = listbook.get(id - 1);
            upbook.setPubDate(updata);
            listbook.set(id - 1, upbook);
            System.out.println("修改成功");
            Book deletebook = listbook.get(id - 1);
            Listlog.updata(deletebook.getBookname());
            for (Book book : listbook) {
                String string = book.toString();
                System.out.println(string);
            }
        }

    //修改图书
    public static void upbookname(int id,String upbookname){
        Book upbook=listbook.get(id-1);
        upbook.setBookname(upbookname);
        listbook.set(id-1,upbook);
        System.out.println("修改成功");
        Book deletebook =listbook.get(id-1);
        Listlog.updata(deletebook.getBookname());
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
        public static void ifoutbook(String outbookname){
            for (int i=0;i<=listbook.size();i++) {
                if (i == listbook.size()){
                    System.out.println("查询失败，请重新输入");
                    break;
                }
                Book ifoutbook =listbook.get(i);
                String name =ifoutbook.getBookname();
                if (name.equals(outbookname)){
                    outbook(ifoutbook.getId());
                    break;
                }

            }

        }
    public static void outbook(int id){
        Book outbook=listbook.get(id-1);
        String temp = "不足";
        if(!temp.equals(outbook.getState())){
            outbook.setState(temp);
            outbook.setCount(1);
            listbook.set(id-1,outbook);
            System.out.println("借书成功，记得按时归还");
            Book deletebook =listbook.get(id-1);
            Listlog.outbook(deletebook.getBookname());
        }else{
            System.out.println("当前书籍库存不足，无法借出");
        }
    }
    public static void ifinbook(String inbookname){
        for (int i=0;i<=listbook.size();i++) {
            if (i == listbook.size()){
                System.out.println("没有查到这本书，请重新输入");
                break;
            }
            Book ifinbook =listbook.get(i);
            String name =ifinbook.getBookname();
            if (name.equals(inbookname)){
                inbook(ifinbook.getId());
                break;
            }

        }

    }
    public static void inbook(int id){
        Book outbook=listbook.get(id-1);
        String temp = "不足";
        String temp2 = "充足";
        if(temp.equals(outbook.getState())){
            outbook.setState(temp2);
            listbook.set(id-1,outbook);
            System.out.println("还书成功，欢迎下次光临");
            Book deletebook =listbook.get(id-1);
            Listlog.inbook(deletebook.getBookname());//日志记录
        }else{
            System.out.println("当前书籍库存充足，检查书名是否输入正确");
        }
    }
    public static int size(){
        return listbook.size();
    }

    public static void updata() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/book";
        String username = "root";
        String password = "root";

        // 1. 加载 JDBC 驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取数据库连接对象
        Connection conn = DriverManager.getConnection(url, username, password);
        //编写sql语句
        String sql = "UPDATE book SET bookname=?, author=?, print=?, pubdata=?, state=?,count=? WHERE id=?";
        //创建 Statement 对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int j=0;
        for (Book book : listbook) {
            preparedStatement.setString(1, book.getBookname());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPrint());
            preparedStatement.setString(4, book.getPubDate());
            preparedStatement.setString(5, book.getState());
            preparedStatement.setInt(6, book.getCount());
            preparedStatement.setInt(7, book.getId());
            int i1 = preparedStatement.executeUpdate();
            j = j + i1;
            if (i1 == 0) {
                add(j);

            }
        }
        preparedStatement.close();
        conn.close();
}
    public static void add(int j) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/book";
        String username = "root";
        String password = "root";

        // 1. 加载 JDBC 驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取数据库连接对象
        Connection conn = DriverManager.getConnection(url, username, password);
        //编写sql语句
        String sql = "insert into book values(?,?,?,?,?,?,?);";
        //创建 Statement 对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (int i=j; i <listbook.size(); i++) {
            Book book = listbook.get(i);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getBookname());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getPrint());
            preparedStatement.setString(5, book.getPubDate());
            preparedStatement.setString(6, book.getState());
            preparedStatement.setInt(7, book.getCount());
            preparedStatement.executeUpdate();
        }

        preparedStatement.close();
        conn.close();
}
}
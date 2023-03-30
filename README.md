# jdbcbook
java连接数据库版本的简易图书管理系统
使用jdbc去对接的话，需要重新构建CRUD 这样难免会花费很长的时间。

为了快速的修改成使用JDBC连接的MySQL，没有改动列表的那些存储，而是把列表整体的存储进去，访问的速度会慢很多，但是学习期间不需要考虑大数量的表查询。

1. 添加jar包

2. 对于ListBook进行改动，增加三个方法，去掉列表初始化

   > 查询book表所有信息

   ```Java
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
   ```

   > 更新book表数据

```java
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
            //判断是否需要插入数据
            if (i1 == 0) {
                add(j);

            }
        }
        preparedStatement.close();
        conn.close();
}
```

> 插入book表数据

```java
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
```

# 后续更新

这个项目目前就结束到这里了，日志和用户也非常好增加，以后有时间再弄

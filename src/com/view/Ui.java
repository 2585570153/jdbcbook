package com.view;
import com.dao.ListBook;
import com.dao.Listlog;
import com.service.*;

import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author : ad
 **/

public class Ui  {
    public Ui() throws SQLException, ClassNotFoundException{
        System.out.println("************************************");
        System.out.println("***********图书管理系统主页面**********");
        System.out.println("*************以下为图书列表***********");
        System.out.println("************************************");
        ListBook.read();
        run();
    }

    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }
    public void run (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("********请选择你的命令进行控制操作*******");
        System.out.println("****1.添加书籍 2.删除书籍 3.修改图书 ****");
        System.out.println("****4.借阅书籍 5.归还书籍 6.查询书籍 ****");
        System.out.println("****7.查阅日志 8.等待更新 9.退出程序 ****");
        System.out.println("************************************");
        String j =scanner.next();
        if(isNumeric(j)){
            int i = Integer.parseInt(j);
            if(i==9){
                try {
                    ListBook.updata();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                System.exit(0);
            }
            fun(i);
        }else{
            System.out.println("请按照规定输入数字，不要挑战这个程序的健壮性");
            run ();
        }
        }

    public void fun(int i){
        Scanner scanner = new Scanner(System.in);
        boolean t=true;
        while(t){
            switch (i){
                case 1:
                    System.out.println("************************************");
                    System.out.println("请输入书名");
                    String bookname = scanner.next();
                    System.out.println("请输入作者");
                    String author = scanner.next();
                    System.out.println("请输入出版社");
                    String print = scanner.next();
                    System.out.println("请输入出版日期");
                    String date = scanner.next();
                    System.out.println("************************************");
                    new Create(bookname,author,print,date,"充足",0);
                    run();
                    break;
                case 2:
                    System.out.println("************************************");
                    System.out.println("*******请输入你删除书籍的id**********");
                    System.out.println("********退出删除书籍功能请按a**********");
                    System.out.println("************************************");
                    String intid = scanner.next();
                    String temp = "a";
                    if (!intid.equals(temp)){
                        if (isNumeric(intid)){
                            int id= Integer.parseInt(intid);
                            new Delete(id);
                        }else {
                            System.out.println("请按照规定输入数字，不要挑战这个程序的健壮性");
                            fun (2);
                        }
                    }else {
                        t=false;
                        run();
                    }
                    break;
                case 3:
                    System.out.println("************************************");
                    System.out.println("*******请输入你修改哪一行书籍**********");
                    System.out.println("********退出修改书籍功能请按b**********");
                    System.out.println("************************************");
                    String upid2 = scanner.next();
                    String temp2 = "b";
                    if (!upid2.equals(temp2)){
                        if (isNumeric(upid2)){
                            int upid= Integer.parseInt(upid2);
                            if (upid> ListBook.size()) {
                                System.out.println("超出范围了");
                                fun (3);
                            }
                                System.out.println("************************************");
                                System.out.println("********请选择你的命令进行控制操作*******");
                                System.out.println("1.修改书名 2.修改作者 3.修改出版社 4.修改出版日期");
                                System.out.println("************************************");
                                String temp3 = scanner.next();
                                if (!isNumeric(temp3)){
                                    System.out.println("请按照规定输入数字，不要挑战这个程序的健壮性");
                                    fun (3);
                                }
                                int temp4= Integer.parseInt(temp3);
                                switch (temp4){
                                    case 1:
                                        System.out.println("请输入修改书名");
                                        String upbookname = scanner.next();
                                        Updata.upbookname(upid,upbookname);
                                        run();
                                        break;
                                    case 2:
                                        System.out.println("请输入修改作者");
                                        String updauthor = scanner.next();
                                        Updata.updauthor(upid,updauthor);
                                        run();
                                        break;
                                    case 3:
                                        System.out.println("请输入修改出版社名字");
                                        String upprint = scanner.next();
                                        Updata.upprint(upid,upprint);
                                        run();
                                        break;
                                    case 4:
                                        System.out.println("请输入修改出版社日期");
                                        String updata = scanner.next();
                                        Updata.updata(upid,updata);
                                        run();
                                        break;
                                    default:
                                        System.out.println("没有这个指令，请重新修改");
                                        fun(3);
                                        break;
                                }


                        }else {
                            System.out.println("请按照规定输入数字，不要挑战这个程序的健壮性");
                            fun (3);}
                    }else {
                        t=false;
                        run();
                    }
                    break;
                case 4:
                    System.out.println("************************************");
                    System.out.println("*******请输入你要查询的书籍名字**********");
                    System.out.println("*********注意：不要加入书名号***********");
                    System.out.println("********退出修改书籍功能请按c**********");
                    System.out.println("************************************");
                    String outname = scanner.next();
                    String temp3 = "c";
                    if (!outname.equals(temp3)){
                        new Outbook(outname);
                    }else {
                        t=false;
                        run();
                    }
                    break;

                case 5:
                    System.out.println("************************************");
                    System.out.println("*******请输入你要还书的书籍名字**********");
                    System.out.println("*********注意：不要加入书名号***********");
                    System.out.println("********退出修改书籍功能请按d**********");
                    System.out.println("************************************");
                    String inname = scanner.next();
                    String temp4 = "d";
                    if (!inname.equals(temp4)){
                        new Inbook(inname);
                    }else {
                        t=false;
                        run();
                    }
                    break;
                case 6:
                    ListBook.forbook();
                    run();
                    break;
                case 7:
                    Listlog.forlog();
                    run();
                    break;
                default:
                    System.out.println("没有这个指令，请重新查询");
                    run();
                    break;
            }
        }
    }

    }






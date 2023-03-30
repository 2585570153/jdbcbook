package com.view;

import java.sql.SQLException;

public class Login {
    String name;
    String password;

    public Login(String name, String password) throws SQLException, ClassNotFoundException {
        this.name = name;
        this.password = password;
        log();
    }
    public void log()throws SQLException, ClassNotFoundException{
        String loginname = "admin";
        String loginpassword = "123456";

        if (name.equals(loginname) && password.equals(loginpassword)){
            System.out.println("登陆成功，欢迎"+name+"使用本系统");
            Ui ui =new Ui();
        }else {
            System.out.println("账号密码错误");
            Index.run();
        }
    }


}

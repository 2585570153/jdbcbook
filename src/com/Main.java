package com;

import com.view.Index;
import com.view.Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author : ad
 **/
public class Main {
    public static void main(String[] args)  throws Exception {
        try {
            // 创建一个 FileReader 对象来读取文件
            FileReader reader = new FileReader("src\\banner.txt");

            // 创建一个 BufferedReader 对象来读取字符流
            BufferedReader bufferedReader = new BufferedReader(reader);

            // 读取文件内容并输出到控制台
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // 关闭文件流
            reader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Index index = new Index();



    }
}
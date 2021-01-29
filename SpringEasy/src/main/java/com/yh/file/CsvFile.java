package com.yh.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CsvFile {

    public static void main(String[] args) {
        try {
            //(文件完整路径),编码格式
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/hui.yang/Downloads/1.csv"), "utf-8"));//GBK
//                 reader.readLine();//显示标题行,没有则注释掉
//                 System.out.println(reader.readLine());
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");//CSV格式文件时候的分割符,我使用的是,号
                String last = item[item.length - 1];//CSV中的数据,如果有标题就不用-1
                System.out.println(line + "   :" + last);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


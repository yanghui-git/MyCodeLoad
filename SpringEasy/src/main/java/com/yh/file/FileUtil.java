package com.yh.file;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

//commons-io的一些用法
public class FileUtil {

    @Test
    //inputStream 变成file
    public void test() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\TSBrowserDownloads", "1.txt"));
        org.apache.commons.io.FileUtils.copyInputStreamToFile(fileInputStream, new File("D:\\TSBrowserDownloads", "2.txt"));
    }

    @Test
    //文件删除
    public void test2() throws Exception {
        // new File("D:\\TSBrowserDownloads","1").delete();2
        FileUtils.forceDeleteOnExit(new File("D:\\TSBrowserDownloads", "1"));
    }

    @Test
    //文件复制
    public void test3() throws Exception {
        FileUtils.copyToFile(new FileInputStream(new File("D:\\TSBrowserDownloads", "1.txt")), new File("D:\\TSBrowserDownloads", "3.txt"));
        ;
    }

    @Test
    //文件写入
    public void test4() throws Exception {
        List<String> test = Arrays.asList(new String[]{"1", "222", "yhhj"});
        FileUtils.writeLines(new File("C:\\Users\\Administrator\\Desktop\\程序员\\", "1.txt"), test);
    }

    @Test
    //文件读取
    public void test5() throws Exception {
       System.out.print(FileUtils.readLines(new File("C:\\Users\\Administrator\\Desktop\\程序员\\","1.txt")));
    }
}

package com.yanghui.testone;

import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class FileTest {

    /**
     * 存放 文件与最后修改时间
     */
    Map<String, Long> fileTime = new HashMap<>();
    File file = new File("C:\\Users\\yanghui\\Desktop\\test.yaml");

    /**
     * 文件流操作
     */
    @Test
    public void getOne() {
        File file = new File("C:\\Users\\yanghui\\Desktop\\YangTest\\test.txt");
        System.out.println(file.lastModified());

    }

    public static void main(String args[]) {
        final File file = new File("C:\\Users\\yanghui\\Desktop\\test.yaml");
        final Map<String, Long> fileTime = new HashMap<>();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (!file.exists() || file.getName() == null) {
                    System.out.println("文件不存在");
                    return;
                }
                System.out.println("文件存在开始进行判断逻辑");
                if (fileTime.get(file.getName()) == null || !fileTime.containsKey(file.getName())) {
                    fileTime.put(file.getName(), file.lastModified());
                }
                Long recentTime = fileTime.get(file.getName());
                Long lastTime = file.lastModified();
                if (lastTime > recentTime) {
                    System.out.println("文件已修改");
                    System.out.println("开始同步文件操作---");
                    try {
                        fileCopyTwo(file.getPath(), "C:\\Users\\yanghui\\Desktop", "TEST.YAML");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fileTime.put(file.getName(), lastTime);
                    System.out.println("文件同步结束");
                    return;
                }
                System.out.println("文件未变动 666666");
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 1000, 5000);
    }

    @Test
    public void fileTest() {

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FileTestttt fileTestttt = new FileTestttt();
            Thread thread = new Thread(fileTestttt);
            thread.start();

        }

    }

    class FileTestttt implements Runnable {

        @Override
        public void run() {
            if (!file.exists() || file.getName() == null) {
                System.out.println("文件不存在");
                return;
            }
            System.out.println("文件存在开始进行判断逻辑");
            if (fileTime.get(file.getName()) == null || !fileTime.containsKey(file.getName())) {
                fileTime.put(file.getName(), file.lastModified());
            }
            Long recentTime = fileTime.get(file.getName());
            Long lastTime = file.lastModified();
            if (lastTime > recentTime) {
                System.out.println("文件已修改");
                System.out.println("开始同步文件操作---");
                try {
                    fileCopy(file.getPath(), "C:\\Users\\yanghui\\Desktop", "TESTT.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fileTime.put(file.getName(), lastTime);
                System.out.println("同步文件操作完成---");
                return;
            }
            System.out.println("文件未修改6666666666");
        }
    }

    /**
     * 文件复制接口方法
     */
    public void fileCopy(String oldfilePath, String newfilePath, String fileName) throws IOException {
        // 源目录
        File oldPath = new File(oldfilePath);
        // 目的地
        File newPath = new File(newfilePath);
        //判断该文件是否存在 为否则创建
        if (!newPath.exists()) {
            newPath.mkdirs();
        }
        InputStream input = new FileInputStream(oldPath);
        FileOutputStream output = new FileOutputStream(newPath + File.separator + fileName);
        FileCopyUtils.copy(input, output);
        input.close();
        output.close();
    }

    /**
     * 文件复制接口方法2
     */
    public static void fileCopyTwo(String oldfilePath, String newfilePath, String fileName) throws IOException {
        // 源目录
        File oldPath = new File(oldfilePath);
        // 目的地
        File newPath = new File(newfilePath);
        //判断该文件是否存在 为否则创建
        if (!newPath.exists()) {
            newPath.mkdirs();
        }
        FileInputStream input = new FileInputStream(oldPath);
        FileOutputStream output = new FileOutputStream(newPath + File.separator + fileName);
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = input.read(bytes)) != -1) {
            output.write(bytes, 0, len);
        }

    }

    @Test
    public void copyTest() throws IOException {
        System.out.println(File.separator + "test.txt");

        FileInputStream inputStream = new FileInputStream("C:\\Users\\yanghui\\Desktop\\1.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\yanghui\\Desktop\\2.txt");
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
    }

}

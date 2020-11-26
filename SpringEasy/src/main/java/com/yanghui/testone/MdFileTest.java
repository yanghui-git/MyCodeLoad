package com.yanghui.testone;//package com.yanghui.testone;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class MdFileTest {
//
//    public static Map<String, String> fileMd = new HashMap<>();
//
//    @Test
//    public void md5Test() {
//
//        while (true) {
//            try {
//                Thread.sleep(5000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            TestFile testFile = new TestFile();
//            Thread thread = new Thread(testFile);
//            thread.start();
//        }
//    }
//
//    class TestFile implements Runnable {
//
//        @Override
//        public void run() {
//            String path = "C:\\Users\\yanghui\\Desktop" + File.separator + "1.txt";
//            String Md5 = null;
//            try {
//                Md5 = DigestUtils.md5Hex(new FileInputStream(path));
//                if (!fileMd.containsKey(path)) {
//                    fileMd.put(path, Md5);
//                }
//                String agoMD = fileMd.get(path);
//                String nowMD = Md5;
//                System.out.println("上次的MD5" + agoMD);
//                System.out.println("这次的MD5" + nowMD);
//                if (!agoMD.equals(nowMD)) {
//                    System.out.println("文件已变更");
//                    fileMd.put(path, nowMD);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }
//
//}

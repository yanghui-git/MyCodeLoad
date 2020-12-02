package com.yh.targz;//package com.yanghui.targz;
//
//import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
//import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
//import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
//import org.apache.commons.compress.utils.IOUtils;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//
//public class TarGz {1
//    /**
//     * .gz文件解压
//     */
//    public static void tarGzFileFunction(String oldFileName, String newFileName) {
//        if (!oldFileName.endsWith(".gz")) {
//            return;
//        }
//        File sourceFile = new File(oldFileName);
//        if (!sourceFile.exists()) {
//            return;
//        }
//        // **tar.gz-->tar
//        TarArchiveInputStream fin = null;
//        try {
//            fin = new TarArchiveInputStream(new GzipCompressorInputStream(new FileInputStream(sourceFile)));
//            File extraceFolder = new File(newFileName);
//            TarArchiveEntry entry;
//            // 将 tar 文件解压到 extractPath 目录下
//            while ((entry = fin.getNextTarEntry()) != null) {
//                if (entry.isDirectory()) {
//                    continue;
//                }
//                File curfile = new File(extraceFolder, entry.getName());
//                File parent = curfile.getParentFile();
//                if (!parent.exists()) {
//                    parent.mkdirs();
//                }
//                // 将文件写出到解压的目录
//                IOUtils.copy(fin, new FileOutputStream(curfile));
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (fin != null) {
//                    fin.close();
//                }
//                boolean delete = sourceFile.delete();
//                System.out.println("删除解压缩原始文件" + delete);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    @Test
//    public void tt(){
//        Date old =new Date();
//        try {
//            Thread.sleep(3000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(new Date().getTime()-old.getTime());
//
//    }
//
//
//
//}

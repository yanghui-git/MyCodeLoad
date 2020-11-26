package com.yanghui.minio.util;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
import java.io.File;
import java.io.FileInputStream;


/**
 * @link https://blog.csdn.net/wangb
 * <p>
 * <p>
 * inaaa/article/details/96031865/
 */
@Service
public class MinIoUtil {

    private String url = "http://10.20.178.85:9000";

    private String access_key = "minioadmin";

    private String access_value = "minioadmin";

    @Bean
    public MinioClient getMin(){
        MinioClient minioClient =null;
        try {
            minioClient=new MinioClient("123","2","4");
           // minioClient.listBuckets();
        } catch (Exception e) {
           System.out.println("minio 连接异常");
           throw new RuntimeException("6666");
        }
        //System.out.println("minio正常");
        return minioClient;
    }

    /**
     * 上传Mino
     */
    public void upload(File file, String bucketName, String contentType) throws Exception {
        if (!file.exists()) {
            System.out.print("No file");
            return;
        }
        MinioClient minioClient = new MinioClient(url, access_key, access_value);
        //判断是否存在桶，即文件夹
        if (!minioClient.bucketExists(bucketName)) {
            System.out.print("Minio 不存在此桶，创建新桶" + bucketName);
            minioClient.makeBucket(bucketName);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        //文件默认覆盖上传
        minioClient.putObject(bucketName, file.getName(), fileInputStream, fileInputStream.available(), contentType);
    }

    @Test
    public void copy() throws Exception {
        System.out.print(System.currentTimeMillis());
//        MinioClient minioClient = new MinioClient(url, access_key, access_value);
//        minioClient.copyObject("yhtest888","1.txt","yhtest666","1.txt");
//        minioClient.copyObject("yhtest888","1.txt","yhtest888","1111.txt");
//        minioClient.copyObject("yhtest888","1.txt","yhtest666","1111.txt");
    }


    @Test
    public void isExist() throws Exception {
        System.out.print(System.currentTimeMillis());
        MinioClient minioClient = new MinioClient(url, access_key, access_value);
        System.out.print(minioClient.statObject("yhtest666", "1.txt"));
    }


    /**
     * Mino删除
     */
    public void delete(String bucketName, String objectName) throws Exception {
        MinioClient minioClient = new MinioClient(url, access_key, access_value);
        minioClient.removeObject(bucketName, objectName);
    }

    @Test
    public void testOne() {
        try {
            upload(new File("D:\\TSBrowserDownloads", "1.txt"), "yhtest888", "application/octet-stream");
        } catch (Exception e) {
            System.out.print("Minio上传文件异常" + e.getMessage());
        }
    }

    @Test
    public void testTwo() {
        try {
            delete("yhtest888", "1.txt");
        } catch (Exception e) {
            System.out.print("Minio删除文件异常" + e.getMessage());
        }
    }

}

package com.yh.minio;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MinioNewUtil {

    public static MinioClient minioClient;

    public static MinioClient getMinioClient() {
        if (minioClient == null) {
            return MinioClient.builder()
                    .endpoint("http://10.20.178.137:9000")
                    .credentials("adminminio", "adminminio")
                    .build();
        }
        return minioClient;
    }

   /* @Bean
    public MinioClient getMin(){
        MinioClient minioClient = null;
        try {
            minioClient = MinioClient.builder()
                    .endpoint("http://10.20.178.137:9000")
                    .credentials("adminminio", "adminminio")
                    .build();
           // minioClient.listBuckets();
        } catch (Exception e) {
            System.out.println("Minio 验证连通性");
            throw new RuntimeException("验证失败");
        }
        System.out.println("minio test");
        return minioClient;
    }*/

}

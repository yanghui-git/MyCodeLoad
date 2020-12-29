import com.yh.minio.MinioNewUtil;
import io.minio.*;
import io.minio.messages.Bucket;
import io.minio.messages.Tag;
import io.minio.messages.Tags;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

// TODO
// Minio 8.0.1测试 主要是新增的一些花里胡哨的功能

public class MinioUtilTestTwo {

    //测试bucket
    @Test
    public void testOne() throws Exception {
        List<Bucket> bucketList = MinioNewUtil.getMinioClient().listBuckets();
        //System.out.println(bucketList.stream().map(bucket -> bucket.name()).collect(Collectors.toList()));
        bucketList.stream().forEach(bucket -> System.out.println(bucket.name()));
      //  Tags tag= MinioNewUtil.getMinioClient().getBucketTags(GetBucketTagsArgs.builder().bucket("new-one").build());
        //获取所有bucket
        // System.out.println(JSON.toJSONString(MinioNewUtil.getMinioClient().listBuckets().toString()));
        //判断bucket是否存在
        System.out.println(MinioNewUtil.getMinioClient().bucketExists(BucketExistsArgs.builder().bucket("new-one").build()));
        //增加一个bucket
        // MinioNewUtil.getMinioClient().makeBucket(MakeBucketArgs.builder().bucket("new-two1").build());
/*
        Map<String, String> map = new HashMap<>();
        map.put("Project", "Project One");
        map.put("User", "test");
        MinioNewUtil.getMinioClient().setBucketTags(
                SetBucketTagsArgs.builder().bucket("new-one").tags(map).build());*/
        System.out.println("Encryption configuration of my-bucketname is set successfully");
    }

    //测试判断文件是否存在
    @Test
    public void testTwo() throws Exception {
        System.out.println(MinioNewUtil.getMinioClient().statObject(StatObjectArgs.builder().bucket("new-one").object("1.txt").build()));
    }


    //测试上传文件
    @Test
    public void testFour() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/hui.yang/Desktop/note.txt");
        /* MinioNewUtil.getMinioClient().putObject(PutObjectArgs.builder()
                     .bucket("new-one").object("note.txt").stream(fileInputStream,fileInputStream.available(),-1)
                  .build());*/

        //加密上传
        ServerSideEncryption sseS3 = new ServerSideEncryptionS3();
        // Create encrypted object 'my-objectname' using SSE-S3 in 'my-bucketname' with content
        // from the input stream.
        MinioNewUtil.getMinioClient().putObject(
                PutObjectArgs.builder().bucket("ota-patch").object("s3.txt").stream(
                        fileInputStream, fileInputStream.available(), -1)
                        .sse(sseS3)
                        .build());

    }

    //测试下载文件
    @Test
    public void testFive() throws Exception {
        //获取下载文件流
        InputStream fileInputStream =
                MinioNewUtil.getMinioClient().getObject(GetObjectArgs.builder().bucket("new-one")
                        .object("note.txt")
                        .build());

        System.out.println(fileInputStream == null);

        //直接下载到本地
        //  MinioNewUtil.getMinioClient().downloadObject(DownloadObjectArgs.builder()
        //           .bucket("bucket-add").object("1.txt")
        //           .filename("/Users/hui.yang/Desktop/testty777777y.txt")
        //          .build());
    }

    //测试复制文件
    @Test
    public void testSix() throws Exception {
        MinioNewUtil.getMinioClient().copyObject(CopyObjectArgs.builder().bucket("new-one").object("copy.txt")
                .source(CopySource.builder().bucket("new-one").object("1.txt").build())
                .build());
    }


    //测试删除文件
    @Test
    public void testServer() throws Exception {
        // MinioNewUtil.getMinioClient().removeObject(RemoveObjectArgs.builder()
        //            .bucket("bucket-add").object("1cope.txt")
        //            .build());
    }

}

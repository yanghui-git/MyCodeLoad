import com.yh.minio.MinioNewUtil;
import io.minio.BucketExistsArgs;
import org.junit.Test;

import java.io.FileInputStream;

/**
 * Minio 8.0.1一些方法测试
 */
public class MinioUtilTest {

    //测试bucket
    @Test
    public void testOne() throws Exception {
        //判断bucket是否存在
        System.out.println(MinioNewUtil.getMinioClient().bucketExists(BucketExistsArgs.builder().bucket("bucket-add-test").build()));
        //增加一个bucket
        // MinioNewUtil.getMinioClient().makeBucket(MakeBucketArgs.builder().bucket("bucket-add").build());
    }

    //测试判断文件是否存在
    @Test
    public void testTwo() throws Exception {
        // System.out.println(MinioNewUtil.getMinioClient().statObject(StatObjectArgs.builder().bucket("bucket-add").object("1.txt").build()));
    }


    //测试上传文件
    @Test
    public void testFour() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/hui.yang/Desktop/note.txt");
        // MinioNewUtil.getMinioClient().putObject(PutObjectArgs.builder()
        //             .bucket("bucket-add-test").object("notetest1.txt").stream(fileInputStream,fileInputStream.available(),-1)
        //          .build());
    }

    //测试下载文件
    @Test
    public void testFive() throws Exception {
        //获取下载文件流
        //  InputStream fileInputStream =
        //         MinioNewUtil.getMinioClient().getObject(GetObjectArgs.builder().bucket("bucket-add-test")
        //                 .object("note.txt")
        //                  .build());

        //  System.out.println(fileInputStream == null);

        //直接下载到本地
        //  MinioNewUtil.getMinioClient().downloadObject(DownloadObjectArgs.builder()
        //           .bucket("bucket-add").object("1.txt")
        //           .filename("/Users/hui.yang/Desktop/testty777777y.txt")
        //          .build());
    }

    //测试复制文件
    @Test
    public void testSix() throws Exception {
        //  MinioNewUtil.getMinioClient().copyObject(CopyObjectArgs.builder().bucket("bucket-add-test").object("copy.txt")
        //            .source(CopySource.builder().bucket("bucket-add").object("1.txt").build())
        //             .build());
    }


    //测试删除文件
    @Test
    public void testServer() throws Exception {
        // MinioNewUtil.getMinioClient().removeObject(RemoveObjectArgs.builder()
        //            .bucket("bucket-add").object("1cope.txt")
        //            .build());
    }
}

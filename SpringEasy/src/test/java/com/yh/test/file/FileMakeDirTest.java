package com.yh.test.file;

import org.junit.Test;

import java.io.File;

public class FileMakeDirTest {

    public static void out(Object object) {
        System.out.println(object);
    }

    @Test
    public void one() throws Exception {
        File file = new File("/Users/hui.yang/Desktop/test/note.txt");
        out(file.exists());
        file = new File("/Users/hui.yang/Desktop/test3/test3333/3.txt");
        //判断上级目录是否存在
        if (!file.getParentFile().exists()) {
            //有多层级目录时 使用mkdirs
            if (file.getParentFile().mkdirs()) {
                out("创建父目录成功");
                file.createNewFile();
                return;
            }
            out("创建父目录失败");
        }
    }
}

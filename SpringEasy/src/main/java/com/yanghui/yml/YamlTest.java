package com.yanghui.yml;

import com.alibaba.fastjson.JSON;
import org.ho.yaml.Yaml;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class YamlTest {

    private static Logger logger = LoggerFactory.getLogger(YamlTest.class);

    @Test
    public void one() {
        ExportYaml exportYaml = null;
        try {
            exportYaml = Yaml.loadType(new File("D:\\桌面\\3.yml"), ExportYaml.class);
            //exportYaml =Yaml.loadType(new FileInputStream(new File("D:\\桌面\\test.yml"),ExportYaml.class));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<WidgetVo> widgetVoList = exportYaml.getWidgetVoList();
        WindowVo windowVo = exportYaml.getWindowVo();

    }

    @Test
    public void Two() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1200000; i++) {
            stringBuilder.append("i");
        }
        ExportYaml exportYaml = new ExportYaml();
        //  exportYaml.setWindowVo(stringBuilder.toString());
        // System.out.println(exportYaml.toString());
        System.out.println(System.lineSeparator());
        System.out.println(System.lineSeparator());
        System.out.println("222");
    }

    @Test
    public void three() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("D:\\桌面\\", "2.yml");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                if (s.startsWith("screenshot: ")) {
                    stringBuilder.append(System.lineSeparator() + s);
                }
            }
            bufferedReader.close();
            System.out.println(stringBuilder);
        } catch (IOException e) {
            stringBuilder.append(e.getMessage());
        }
    }

    private static void saveAsFileWriter(String filePath, String fileName, String content) {
        //删除原文件
        File file = new File(filePath, fileName);
        file.delete();
        FileWriter writer = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            new FileWriter(file);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void test() {
        int a = 3;
        while (a > 0) {
            System.out.println("6666");
            a = a - 1;
        }

        logger.error("name :{} ; age : {}", "yh", 20);

        logger.error(String.format("this is test name %s ; age %s", "yyhh", 20));

        logger.error("项目名 : {} 模块名 {} 优秀啊 {}", "show", "data", 66666);
    }


}

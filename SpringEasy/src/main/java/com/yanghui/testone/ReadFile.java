package com.yanghui.testone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("C:\\Users\\yanghui\\Desktop\\","tes.class");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(System.lineSeparator() + s);
            }
            bufferedReader.close();
            System.out.println(stringBuilder);
        } catch (IOException e) {
            stringBuilder.append(e.getMessage());
        }
    }
}

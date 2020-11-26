package com.yanghui.testone;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MibForTest {

    @Test
    public void tes() {
        List<Mib> mibList = new ArrayList<>();
        Mib mib1 = new Mib("1", "11", "111");
        Mib mib2 = new Mib("2", "22", "222");
        Mib mib3 = new Mib("3", "33", "333");
        mibList.add(mib3);
        mibList.add(mib2);
        mibList.add(mib1);
        List<String> test = new ArrayList<>();
        test.add("2");
        test.add("1");
        test.add("3");
        List<Mib> result = new ArrayList<>();
        for (String te : test) {
            for (Mib mm : mibList) {
                if (mm.getFilename().equals(te)) {
                    result.add(mm);
                   // continue;
                    break;
                }
            }
        }
        System.out.println(JSON.toJSONString(result));
    }

}

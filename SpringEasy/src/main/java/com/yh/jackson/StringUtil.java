package com.yh.jackson;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    /**
     * 统计字符串中字符出现的次数
     *
     * @param s 字符串
     * @param c 待统计字符
     */
    public static int countChar(String s, char c) {
        if (s == null)
            return 0;
        else {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c)
                    count++;
            }
            return count;
        }
    }

    public static String[] split(String src, String delimit) {
        if ((src == null) || (delimit == null))
            return null;
        List<String> stList = new ArrayList<>();
        int curPos = 0;
        int prePos = 0;
        int delimitLen = delimit.length();
        while (true) {
            curPos = src.indexOf(delimit, curPos);
            if (curPos < 0) {
                if (prePos > src.length())
                    break;
                stList.add(src.substring(prePos, src.length()));
                break;
            }

            if (curPos >= prePos) {
                stList.add(src.substring(prePos, curPos));
            }
            curPos += delimitLen;
            prePos = curPos;
        }
        String[] ret = new String[stList.size()];
        stList.toArray(ret);
        return ret;
    }

    /**
     * @param string 发短信的内容
     * @return 将.换成_
     * 去除https:和http:
     */
    public static String SMSMsgReplace(String string) {
        String tmp = "";
        if (string == null) {
            return tmp;
        }
        tmp = string.replaceAll("\\.", "_");
        tmp = tmp.replaceAll("https:", "");
        tmp = tmp.replaceAll("http:", "");
        return tmp;
    }

    public static String toStringOrEmpty(Object string) {
        if (string == null) {
            return "";
        }
        return string.toString();
    }

    /**
     * 获取指定字符串出现的次数
     *
     * @param srcText  源字符串
     * @param findText 要查找的字符串
     * @return
     */
    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static boolean isNull(String str) {
        return str == null || "null".equals(str.trim()) || "".equals(str.trim());
    }

    public static boolean isNotNull(String str) {
        return str != null && !"null".equals(str.trim()) && !"".equals(str.trim());
    }

    public static boolean isEmpty(String str) {
        if (str == null || "null".equals(str.trim()) || "".equals(str.trim()) || str.length() == 0) {
            return true;
        }
        return false;
    }

}

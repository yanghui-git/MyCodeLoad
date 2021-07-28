package com.yh.math.easy;

import org.junit.Test;

public class Easy557 {

    @Test
    public void testOne(){
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }

    class Solution {
        public String reverseWords(String s) {
            String result="";
            String[] nums=s.split(" ");
            for(String str:nums){
                //反转
                char[] strNum=str.toCharArray();
                for(int i=0;i<strNum.length/2;i++){
                    char tmp=strNum[i];
                    strNum[i]=strNum[strNum.length-1-i];
                    strNum[strNum.length-1-i]=tmp;
                }
                result+=" "+new String(strNum);
            }
            return result.replaceFirst(" ","");
        }
    }
}

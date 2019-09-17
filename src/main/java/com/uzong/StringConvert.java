package com.uzong;

import org.junit.Assert;
import org.junit.Test;

/**
 * @desc Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时
 *
 */
public class StringConvert {

    @Test
    public void testConvert() {
        String s = "LEETCODEISHIRING";
        int numRows = 1;
        String result = convert(s,numRows);
        System.out.println(result);
        String s2 = "LEETCODEISHIRING";
        Assert.assertTrue(s2.equals(result));
    }

    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1) {
            return s;
        }
        int len = s.length();
        Character[][] chars = new Character[len][len];

        boolean addNumFlag = true;
        int x = 0;
        int y = 0;

        for(int i = 0; i < len; i++) {
            if(addNumFlag) {
                chars[x][y] = s.charAt(i);
                y++ ;
                if(y >= numRows) {
                    addNumFlag = false;
                    y = numRows - 1;
                }
            }
            if(!addNumFlag) {
                chars[x][y] = s.charAt(i);
                y--;
                x++;
                if(y < 0) {
                    addNumFlag = true;
                    y = 1;
                    x --;
                }
            }
        }
        printChars(chars,s.length());
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(chars[j][i] != null) {
                    builder.append(chars[j][i]);
                }
            }
        }
        return builder.toString();
    }

    void printChars(Character[][] chars,int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                System.out.print(chars[j][i] == null ? "  " : chars[j][i] + " ");
            }
            System.out.println();
        }
    }
}

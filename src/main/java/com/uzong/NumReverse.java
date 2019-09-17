package com.uzong;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class NumReverse {


    public int reverse(int x) {
        if(x == 0) {
            return 0;
        }
        String numStr = String.valueOf(x);
        String symbol = String.valueOf(numStr.charAt(0));
        if(symbol.equals("-")) {
            symbol = "-";
        } else {
            symbol = "";
        }
        StringBuilder builder = new StringBuilder();
        for(int i = numStr.length()-1; i >= 0; i--) {
            if(!"-".equals(String.valueOf(numStr.charAt(i)))) {
                builder.append(numStr.charAt(i));
            }
        }
        String  builderStr =  builder.toString();
        while (String.valueOf(builderStr.charAt(0)).equals("0")) {
            builderStr = (String) builderStr.subSequence(1,builderStr.length());
        }

        String resultStr = (symbol.equals("-")) ? (symbol+builderStr): builderStr;
        long resultNum = Long.parseLong(resultStr);
        if(resultNum > Integer.MAX_VALUE || resultNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)resultNum;
    }

    @Test
    public void testReverse() {
        int num = 10;
        System.out.println(reverse(num));
        Assert.assertTrue(1 == reverse(num));
    }
}

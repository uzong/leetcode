package com.uzong;

import org.junit.Test;

/**
 * @author huzongyong
 */
public class Atoi {


    @Test
    public void testInt() {
        Character.isDigit(0);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void testMyAtoi() {
        String s = "-01";
        System.out.println(myAtoi(s));
    }

    public int myAtoi(String str) {

        StringBuilder numStrBuilder = new StringBuilder();
        String symbolStr = "";
        boolean haveNum = false;
        boolean symbol = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (haveNum) {
                    break;
                }
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                if (!symbol && !haveNum) {
                    symbol = true;
                    symbolStr = String.valueOf(str.charAt(i));
                } else {
                    break;
                }
                haveNum = true;
            } else if (Character.isDigit(str.charAt(i))) {
                haveNum = true;
                numStrBuilder.append(str.charAt(i));
            } else {
                break;
            }
        }

        //去掉前面的0
        String numStr =  numStrBuilder.toString();
        while (numStr.length() > 0 && numStr.charAt(0) == '0') {
            numStr = numStr.substring(1,numStr.length());
        }

        String resultStr = symbolStr + numStr;

        try {
            //字符串太长，超过long
            if(resultStr.length() > 11) {
                return symbolStr.equals("-") ?  Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            long resultNum = Long.valueOf(resultStr);
            if (resultNum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (resultNum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) resultNum;
        } catch (Exception e) {
            return 0;
        }
    }
}
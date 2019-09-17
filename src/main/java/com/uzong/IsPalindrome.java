package com.uzong;

import org.junit.Test;

/**
 * @author huzongyong
 */
public class IsPalindrome {

    @Test
    public void testIsPalindrome() {
        System.out.println(isPalindrome(74847412));
    }
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        String numStr = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        for (int i = numStr.length()-1; i >=0 ; i--) {
            builder.append(numStr.charAt(i));
        }
        if (Long.parseLong(builder.toString()) - x == 0) {
            return true;
        }
        return false;
    }
}
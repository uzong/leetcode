package com.uzong;

import org.junit.Test;

/**
 * 最长回文串
 */
public class LongestPalindrome {

    @Test
    public void testLongestPalindrome() {
        String s = " "; //abcd
        System.out.println(longestPalindrome(s));
    }

    /**
     * 自己实现的一种方法
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len    = s.length();
        int maxLen = 0;
        int start  = 0;
        int end    = 0;

        for (int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                if(chars[i] == chars[j]) {
                    boolean flag =  true;
                    int left  = i;
                    int right = j;
                    while(left < right) {
                        if(chars[left++] != chars[right--]) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        int distance =  j - i;
                        if(distance > maxLen) {
                            maxLen = distance;
                            start  = i;
                            end    = j + 1;
                        }
                    }

                }
            }
        }
        String result = s.substring(start, end);
        if(result.length() == 0) {
           result = s.substring(0,1);
        }
        return result;
    }
}

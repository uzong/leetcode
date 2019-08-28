package com.uzong;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxVal = 0;
        HashMap<Character,Integer> map = new HashMap(chars.length);
        for(int i = 0; i < chars.length; i++) {
            for(int j = i; j < chars.length; j++) {
                if(map.containsKey(chars[j])) {
                    maxVal = maxVal > map.size() ?  maxVal : map.size();
                    map.clear();
                    break;
                }else {
                    map.put(chars[j],j);
                }
            }
            maxVal = maxVal > map.size() ? maxVal : map.size();
            map.clear();
        }
        return maxVal;
    }

    @Test
    public void testLengthOfLongestSubstring() {
        String str = "cdd";
        System.out.println(lengthOfLongestSubstring(str));
        Assert.assertTrue(2 == lengthOfLongestSubstring(str));
    }
}

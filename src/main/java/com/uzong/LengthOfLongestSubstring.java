package com.uzong;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * @desc 无重复字符的最长子串
 * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
 *
 */

public class LengthOfLongestSubstring {

    /**
     * 方法一： 暴力
     */
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


    /**
     * 方法二：滑动窗口。 算法不够优秀，2n的时间复杂度。
     */
    public int lengthOfLongestSubstring2(String s) {
        int i = 0;
        int j = 0;
        int maxVal = 0;
        //采用滑动窗口
        Set<Character> set =  new HashSet<>();
        int len = s.length();
        while (i < len && j < len) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxVal = Math.max(maxVal,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return maxVal;
    }

    /**
     * 方法三：优化滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int start = 0;
        int maxVal = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                start = Math.max(map.get(s.charAt(j)) + 1,start);
            }
            maxVal = Math.max(maxVal,j-start+1);
            map.put(s.charAt(j),j);
        }
        return maxVal;
    }

    /**
     * 当需要的数组较小是可以使用该方法
     */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    @Test
    public void testLengthOfLongestSubstring() {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
        Assert.assertTrue(3 == lengthOfLongestSubstring3(str));
    }
}

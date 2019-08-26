package com.uzong;

import org.junit.Assert;
import org.junit.Test;

import java.beans.Transient;
import java.util.HashMap;

/**
 * @Desc 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 链接：https://leetcode-cn.com/problems/two-sum
 * @author uzong
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if (len <= 1) {
            return null;
        }
        for(int i = 0; i < len-1; i++) {
            for(int j = i + 1; j < len; j++) {
                if((nums[i] + nums[j]) == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * 方法一：暴力求解的方法。时间复杂度 n^2^
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法二：采用Hash算法。两次hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++) {
           int complement  = target - nums[i];
           if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i,map.get(complement)};
           }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 方法三：采用一次Hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expect = {0,1};
        Assert.assertArrayEquals(expect,twoSum3(nums,target));
    }
}
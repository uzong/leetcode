package com.uzong;


import org.junit.Assert;
import org.junit.Test;

/**
 * @Descirption 寻找中位数
 * @Author uzong
 * @Date 2019/9/1
 * @Version 1.0
 */
public class FindMedianSortedArrays {

    @Test
    public void testoddAndEven() {
        System.out.println(4&1);
        System.out.println((2d+3)/2);
        Assert.assertTrue(((4 & 1) == 0)); //偶数
        Assert.assertTrue(((3 & 1) == 1)); //奇数
    }

    @Test
    public void testFindMedianSortedArrays() {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double current = 0;
        if(len1 == 0) {
            return (len2 & 1) == 1 ?
                    nums2[len2/2] :
                    ((double) nums2[len2/2] + nums2[len2/2 - 1])/2;
        } else if (len2 == 0) {
            return (len1 & 1) == 1 ?
                    nums1[len1/2] :
                    ((double)nums1[len1/2] + nums1[len1/2 - 1])/2;
        } else {
            int totalLen = len1 + len2;
            int count = 0;
            int i = 0,j = 0;
            double prenum = 0;
            while (i < len1 || j < len2) {
                if(i < len1 && j < len2 && nums1[i] <= nums2[j]) {
                    current = nums1[i];
                    i = i + 1;
                } else if (i < len1 && j < len2 && nums1[i] > nums2[j]) {
                    current = nums2[j];
                    j = j + 1;
                } else {
                   if(i >= len1 && j < len2) {
                       current = nums2[j];
                       j = j + 1;
                   }
                   if(i < len1 && j >= len2) {
                       current = nums1[i];
                       i = i + 1;
                   }
                }
                //如果长度是奇数，则一半的时候就是中位数
                if((totalLen & 1) == 1) {
                    if((totalLen / 2) == count) {
                        return current;
                    }
                } else {
                    //如果是偶数，则当计数到一半的时候，只需要将当前值和前面一个值
                    //求平均即可。
                    if((totalLen / 2) == count) {
                        return (current + prenum) / 2;
                    }
                    if((totalLen / 2) == (count + 1)) {
                        prenum = current;
                    }
                }
                count ++;

            }
        }
        throw new IllegalArgumentException("no result");
    }
}
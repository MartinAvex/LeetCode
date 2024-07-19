package com.xavier.leetcode;

import java.util.HashMap;

/**
 * 136. 只出现一次的数字:
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 示例 1 ：
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class _136_SingleNumber {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,1,2,3};
        System.out.println(singleNumber(nums));
    }

    //12ms 击败10.04%
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null) {
                map.put(nums[i], ++value);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    //1ms 击败97.66%
    /*利用位运算的两个性质：两个相同数异或为0（a^a=0）、任何数与0异或都为其本身（a^0=a）。所以，直接将数组所有数异或，即可得到那个唯一的数。并且为运算满足交换律：a^b^c^b^a = a^a^b^b^c*/
    public static int singleNumber_01(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
























}

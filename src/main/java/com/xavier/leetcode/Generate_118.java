package com.xavier.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 */
public class Generate_118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    /**
     * n = 1时， arr = [1]
     * n = 2时， arr = [1,1]
     * n > 2时， arr = [1,2,1]
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        for (int numRow = 0; numRow < numRows; numRow++) {
            ArrayList<Integer> rowList = new ArrayList<Integer>(numRow+1);
            for (int i = 0; i <= numRow; i++) {
                if (i == 0 || i == numRow) {
                    rowList.add(1);
                } else {
                    rowList.add(result.get(numRow-1).get(i-1) + result.get(numRow-1).get(i));
                }
            }
            result.add(rowList);
        }
        return result;
    }

}

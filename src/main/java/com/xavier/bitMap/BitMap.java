package com.xavier.bitMap;

import org.springframework.util.StopWatch;

import java.util.BitSet;
import java.util.concurrent.TimeUnit;

/**
 * 给40亿个不重复的无符号整数，没排过序。给一个无符号整数，如何快速判断一个数是否在这40亿个数中。
 *
 * 已知：无符号整数的取值范围为：0 ~ 2^32-1 即：0 ~ 4294967295
 * 使用位图存储数据需要的空间：4294967295/8/1024/1024 = 512MB
 *
 * 解题思路：将整数按照16bit进行拆分，32为整数拆分为个部分，将这3个部分存储到3个set中。判断一个数字是否存在时，判断该数字的所有bit位是否相同，从而判断数字是否存在
 *
 * 1、高位bit：number & 0xFFFF0000 [24 ~ 32]
 * 2、中位bit：number & 0x00FFFF00 [16 ~ 24]
 * 3、低位bit：number & 0x0000FFFF [0 ~ 16]
 *
 * int是有符号的32位整数，取值范围最大位：2^32-1 = 2147483647
 *
 */
public class BitMap {

    public static void main(String[] args) {
        checkBillionNumber();
        //checkBillionByBitMap();
    }

    private static void checkBillionByBitMap() {
        int rand = 0;
        BitSet bitMap = new BitSet();
        for (long i = 0; i < 42949672L; i++) {
            rand = (int) (Math.random() * (1073741823 - 0) + 0);
            bitMap.set(rand);
        }
        int number = (int) (Math.random() * (1073741823 - 0) + 0);
        System.out.println(number);
        System.out.println((number & 0xFFFF0000) | (number & 0x00FFFF00) | (number & 0x0000FFFF));
        System.out.println(bitMap.get(number));
    }

    private static void checkBillionNumber() {
        StopWatch stopWatch = new StopWatch("40亿数据生成运行时间检测");
        stopWatch.start();
        int rand = 0;
        Billion billion = new Billion();
        for (long i = 0; i < 4294967296L; i++) {
            rand = (int) (Math.random() * (1073741823 - 0) + 0);
            billion.add(rand);
        }
        stopWatch.stop();
        stopWatch.prettyPrint();
        int number = (int) (Math.random() * (1073741823 - 0) + 0);
        System.out.println(number);
        System.out.println((number & 0xFFFF0000) | (number & 0x00FFFF00) | (number & 0x0000FFFF));
        System.out.println(billion.isExist(number));
    }

}

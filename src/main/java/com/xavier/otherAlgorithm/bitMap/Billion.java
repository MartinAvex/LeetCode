package com.xavier.otherAlgorithm.bitMap;

import java.util.HashSet;
import java.util.Set;

public class Billion {

    private Set<Integer> set32_24, set24_16, set16_0;

    public Billion() {
        this.set32_24 = new HashSet<Integer>();
        this.set24_16 = new HashSet<Integer>();
        this.set16_0 = new HashSet<Integer>();
    }

    public void add(int number) {
        int val32_24, val24_16, val16_0;
        val32_24 = number & 0xFFFF0000;
        val24_16 = number & 0x00FFFF00;
        val16_0 = number & 0x0000FFFF;

        if (!(set32_24.contains(val32_24) && set24_16.contains(val24_16) && set16_0.contains(val16_0))) {
            set32_24.add(val32_24);
            set24_16.add(val24_16);
            set16_0.add(val16_0);
        }
    }

    public boolean isExist(int number) {
        int val32_24, val24_16, val16_0;
        val32_24 = number & 0xFFFF0000;
        val24_16 = number & 0x00FFFF00;
        val16_0 = number & 0x0000FFFF;
        return set32_24.contains(val32_24) && set24_16.contains(val24_16) && set16_0.contains(val16_0);
    }

}

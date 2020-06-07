package com.yueyang.tenaugorithm.kmp;

import java.util.Arrays;

/**
 * @program: augorithm
 * @description: kmp算法
 * @author: qinxiangyang
 * @create: 2020-06-06 03:55
 **/
public class KmpAugorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = nextInt("ABCDABD"); //[0, 1, 2, 0]
        System.out.println("next=" + Arrays.toString(next));
        int i = kmpSearch(str1, str2, next);
        System.out.println("index: " + i);
    }

    public static int kmpSearch(String str1, String str2, int[] chars) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //处理chars[i] != chars[j]，kmp的核心点，调整j的大小
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = chars[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 获取next数组
     *
     * @return
     */
    public static int[] nextInt(String str) {
        //转换成字符数组
        char[] chars = str.toCharArray();
        int[] nextInt = new int[chars.length];
        for (int i = 1, j = 0; i < chars.length; i++) {
            //kmp算法的核心，
            while (j > 0 && chars[i] != chars[j]) {
                j = nextInt[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            nextInt[i] = j;
        }
        return nextInt;
    }

}
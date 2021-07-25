package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int x = 4;
        System.out.println(digitSum(2345));
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr,3);
        Arrays.stream(arr).forEach(e-> System.out.print(e+ ", "));
        System.out.println();


        System.out.println(f(20));

        System.out.println(f(4));

    }

    public static int doSum(int x) {
        if (x == 1) {
            return 1;
        }
        int sum = 0;
        sum = sum + x;
        doSum(x - 1);
        return sum;

    }

    static int prod(int x) {
        if (x == 1) {
            return 1;
        }
        return x * prod(x - 1);
    }

    static int f(int x) {
        if (x >= 12) {
            return x - 1;
        }
        return f(f(x + 2));

    }

    static int digitSum(int x) {
        if (x == 0) {
            return 0;
        }
        return x % 10 + digitSum(x / 10);
    }

    static void rotate(int[] ints, int d) {
        int x = 0;
        while (x != d) {
            leftRotateByOne(ints);
            x++;
        }

    }

    private static void leftRotateByOne(int[] ints) {
        int x = ints[0];
        for (int j = 0; j < ints.length - 1; j++) {
            ints[j] = ints[j + 1];

        }
        ints[ints.length - 1] = x;
    }


}




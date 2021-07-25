package com.company;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a1 = {15,40,41,43};
        int[] a2 = {9,18,51};
       print(mergeSort(a1,a2));
    }
    private static int[] mergeSort(int[] a1,int a2[]){
        int[] arr = new int[a1.length+a2.length];
        int i = 0;
        int j = 0;
        int w = 0;
        while(i<a1.length && j<a2.length){
            if(a1[i]<a2[j]){
                arr[w++]=a1[i];
                i++;
            }else {
                arr[w++]=a2[j];
                j++;
            }
        }
        while(i<a1.length){
            arr[w++]=a1[i];
            i++;
        }
        while(j<a2.length){
            arr[w++]=a2[j];
            j++;
        }
        return arr;
    }
    public static void print(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
}

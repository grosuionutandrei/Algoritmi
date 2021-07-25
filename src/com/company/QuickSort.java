package com.company;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int[]arr= {2,4,6,4,2,89,54,76,23};

        int end = arr.length;

        quickSort(arr,0,end-1);
        Arrays.stream(arr).forEach(e-> System.out.println(e + ", "));

    }
    public static  void quickSort(int[]arr,int start,int end){
        if(start<end){
            int piv = partition(arr,start,end);
            quickSort(arr,start,piv-1);
            quickSort(arr,piv+1,end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int piv = arr[end];
        int i = start-1;
        for(int j = start ; j<=end-1;j++){
            if(arr[j]<piv){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = piv;
        arr[end] = temp;
        piv=i+1;
        System.out.println(piv+"kjoi");



        return  piv;
    }
}

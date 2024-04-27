package com.bruno13palhano;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {9,1,2,5,3,7,14,13,45,43,11,23,45,3};

        System.out.println(Arrays.toString(arr));
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j > -1 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}
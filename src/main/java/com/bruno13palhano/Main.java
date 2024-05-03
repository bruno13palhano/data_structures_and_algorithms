package com.bruno13palhano;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {100,90,80,7,8,5,4,1,2,3};

        System.out.println(Arrays.toString(arr));
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{100,90,80,7,8,5,4,1,2,3};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,  0, arr.length-1);
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

    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start+end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    static void merge(int[] array, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        int i, j, k = start;

        for (i = 0; i < leftSize; i++) leftArray[i] = array[start + i];

        for (j = 0; j < rightSize; j++) rightArray[j] = array[middle + j + 1];

        i = 0;
        j = 0;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) array[k++] = leftArray[i++];
            else array[k++] = rightArray[j++];
        }

        while (i < leftSize) array[k++] = leftArray[i++];

        while (j < rightSize) array[k++] = rightArray[j++];
    }
}
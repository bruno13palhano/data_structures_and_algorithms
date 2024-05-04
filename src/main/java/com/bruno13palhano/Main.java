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

    static void mergeSort(int[] workspace, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int middle = (lowerBound+upperBound) / 2;
            mergeSort(workspace, lowerBound, middle);
            mergeSort(workspace, middle + 1, upperBound);
            merge(workspace, lowerBound, middle, upperBound);
        }
    }

    static void merge(int[] workspace, int lowerBound, int middle, int upperBound) {
        int leftSize = middle - lowerBound + 1;
        int rightSize = upperBound - middle;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        int i, j, k = lowerBound;

        for (i = 0; i < leftSize; i++) leftArray[i] = workspace[lowerBound + i];

        for (j = 0; j < rightSize; j++) rightArray[j] = workspace[middle + j + 1];

        i = 0;
        j = 0;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) workspace[k++] = leftArray[i++];
            else workspace[k++] = rightArray[j++];
        }

        while (i < leftSize) workspace[k++] = leftArray[i++];

        while (j < rightSize) workspace[k++] = rightArray[j++];
    }
}
package org.example.timeComplexity;

import java.util.Arrays;

public class ONExample {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2; // 단순히 한 번씩 접근
        }
        System.out.println(Arrays.toString(arr));
    }
}

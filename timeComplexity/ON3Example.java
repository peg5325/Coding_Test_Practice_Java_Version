package org.example.timeComplexity;

public class ON3Example {
    public static void main(String[] args) {
        int n = 3;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    count++;
                }
            }
        }
        System.out.println("Total operations: " + count);
    }
}

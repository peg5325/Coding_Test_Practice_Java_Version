package org.example.search;

import java.io.*;
import java.util.*;

public class Bj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int currentPush = 1;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            while (currentPush <= target) {
                stack.push(currentPush);
                sb.append("+\n");
                currentPush++;
            }

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb.toString());
    }
}

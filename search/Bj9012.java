package org.example.search;

import java.io.*;
import java.util.*;

public class Bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            sb.append(solve(ps)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static String solve(String ps) {
        Stack<Character> stack = new Stack<>();

        for (char ch : ps.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else { // ch == ')'
                if (stack.isEmpty()) {
                    return "NO"; // 스택이 비어있는데 닫는 괄호가 나오면 VPS가 아님
                }
                stack.pop(); // 짝이 맞는 괄호이므로 스택에서 제거
            }
        }

        // 모든 문자를 처리한 후 스택이 비어있으면 YES, 아니면 NO
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}

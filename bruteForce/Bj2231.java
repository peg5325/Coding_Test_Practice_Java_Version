package org.example.bruteForce;

import java.io.*;

public class Bj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 1; i < n; i++) {
            // 분해합은 자기자신의 값으로 시작
            int sum = i;

            // i를 문자열로 변경 -> 각 자리의 수를 파악하기 위함.
            String s = String.valueOf(i);

            // 각 자리의 수를 더함.
            for (int j = 0; j < s.length(); j++) {
                sum += Character.getNumericValue(s.charAt(j));
            }

            // 분해합이 입력한 자연수 N과 같을 경우 종료 및 result 저장
            // 1부터 올라왔기 때문에 가장 작은 생성자를 보장.
            if (sum == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}

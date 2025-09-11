package org.example.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bj10448 {
    public static void main(String[] args) throws IOException {

        // Tn = 1 + 2 + 3 + ... + n = n(n+1)/2

        // 테스트 케이스의 개수를 입력
        // 자연수 K를 입력 받음(3 <= K <= 1,000)
        // K가 '정확히 3개의 삼각수의 합'으로 표현될 수 있으면 1, 아니면 0을 출력

        // T1 = 1
        // 1 * (1 + 1) / 2 = 1
        // T2 = 3
        // 2 * (2 + 1) / 2 = 3
        // 이런식으로 1000까지 계산해서 Tn 배열을 생성
        // ex) T[] = 1, 3, 6, 10, 15 ...
        // 수를 입력 받으면 위 수 중에서 3가지를 골라 합했을 때, 입력받은 수와 같아지면 1, 아니면 0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        // 삼각수 배열 생성
        List<Integer> list = new ArrayList<>();
        int a = 1;
        while (true) {
            int b = a * (a + 1) / 2;
            if (b > 1000) {
                break;
            } else {
                list.add(b);
                a++;
            }
        }

        // TestCase 수만큼 반복
        for (int i = 0; i < tc; i++) {

            // 메인 로직
            int num = Integer.parseInt(br.readLine());
            boolean flag = false;

            for (int j = 0; j < list.toArray().length; j++) {
                for (int k = 0; k < list.toArray().length; k++) {
                    for (int l = 0; l < list.toArray().length; l++) {
                        if (list.get(j) + list.get(k) + list.get(l) == num) {
                            flag = true;
                            j = list.toArray().length;
                            k = list.toArray().length;
                            l = list.toArray().length;
                        }
                    }
                }
            }

            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

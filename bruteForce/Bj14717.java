package org.example.bruteForce;

import java.io.*;
import java.util.*;

public class Bj14717 {
    public static void main(String[] args) throws IOException {
        // 섯다 룰(1~10까지 2장씩 20장, 2명이 각각 2장씩 뽑음)
        // 같은 수 2개면 땡, 10에 가까울 수록 승리
        // 서로 다른 수의 카드 2장이라면 끗,
        // 두 수를 더해서 일의 자리의 수가 높을수록 승리
        // 패가 주어졌을 때, 이길 수 있는 확률을 구해야함.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 모든 카드 생성
        List<Integer> all = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            // 2장식
            all.add(i);
            all.add(i);
        }

        // 내가 가진 카드 제외
        all.remove((Integer) a);
        all.remove((Integer) b);

        // 내 카드 조합을 점수로 표시하기
        // 끗이 0~9까지 이므로, 땡은 a * 10을 하면 비교가 편해진다.
        // 따로 함수를 만들어 재활용하자.
        int win = 0;
        int total = 0;
        int my = combi(a, b);

        for (int i = 0; i < all.size(); i++) {
            for (int j = i + 1; j < all.size(); j++) {
                int x = all.get(i);
                int y = all.get(j);
                int your = combi(x, y);
                if (my > your) {
                    win++;
                }
                total++;
            }

        }
        System.out.printf("%.3f\n", (double)win/total);
    }

    // 점수 계산
    static int combi(int x, int y) {
        if (x == y) {
            return x * 10;
        } else {
            return (x + y) % 10;
        }
    }

}

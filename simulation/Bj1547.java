package org.example.simulation;

import java.io.*;
import java.util.*;

public class Bj1547 {
    public static void main(String[] args) throws IOException {
        // 컵의 위치를 바꾼 횟수 M, M <= 50 자연수
        // 컵의 위치를 바꾼 자리 X, Y / X, Y <= 3 / X == Y도 가능

        // 무조건 1번 컵에 공을 넣고 시작.
        // M번 만큼 X, Y에 있는 공을 바꿈.
        // M번의 바꾸기가 끝나고, 공이 들어있는 컵의 번호를 출력.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int[] cups = {0, 1, 0, 0};

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int temp = 0;

            temp = cups[x];
            cups[x] = cups[y];
            cups[y] = temp;
        }

        int result = 0;

        for (int i = 1; i < cups.length; i++) {
            if (cups[i] == 1) {
                result = i;
            }
        }

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}

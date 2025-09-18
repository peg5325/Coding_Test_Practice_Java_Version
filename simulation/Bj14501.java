package org.example.simulation;

import java.io.*;
import java.util.*;

public class Bj14501 {
    public static void main(String[] args) throws IOException {
        // N + 1 일 후 퇴사 예정
        // 그 전에 최대한 돈을 땡겨보려함.
        // Ti = 상담에 걸리는 기간(단위: 일)
        // Pi = 상담을 진행 했을 때, 받을 수 있는 비용
        // 얻을 수 있는 최대 수익을 구하는 문제.

        // 길이 N의 Ti와 Pi 배열을 생성
        // 입력 받은 Ti와 Pi를 배열에 저장.
        // max 값을 저장할 변수 생성
        // 첫날 시작해서 가능한 상담건을 진행 후 금액을 max에 저장.
        // 다음 둘째날부터 가능한 상담건 진행 후 max 값과 비교해서 큰 값을 저장.
        // 마지막에 저장된 max 값을 출력

        // > 추가 고려사항 <
        // 바로 더하는 것이 아닌 더 나은 값이 있는지 탐색해야함.
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; // N+1일까지 필요

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 거꾸로 계산
        for (int i = N; i >= 1; i--) {
            // 현재 상담을 하는 경우
            if (i + T[i] <= N + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            } else {
                // 현재 상담 불가능하면 그냥 다음날 값 가져오기
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}

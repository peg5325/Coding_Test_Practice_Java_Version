package org.example.search;

import java.io.*;
import java.util.*;

public class Bj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개의 카드 입력 및 HashMap에 빈도수 저장
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardCounts = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            // getOrDefault를 사용해 해당 카드의 개수를 1 증가시킴
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        // M개의 정수 입력 및 개수 확인
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            // getOrDefault를 사용해 해당 카드의 개수를 가져옴. 없으면 0을 반환
            sb.append(cardCounts.getOrDefault(target, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}

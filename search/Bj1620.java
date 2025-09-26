package org.example.search;

import java.io.*;
import java.util.*;

public class Bj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 번호-이름 Map
        HashMap<Integer, String> numToName = new HashMap<>();
        // 2. 이름-번호 Map
        HashMap<String, Integer> nameToNum = new HashMap<>();

        // N개의 포켓몬 정보 저장
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToName.put(i, name);
            nameToNum.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        // M개의 문제 해결
        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            // 입력값이 숫자인지 문자인지 첫 글자로 판단
            if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
                sb.append(numToName.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(nameToNum.get(input)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}

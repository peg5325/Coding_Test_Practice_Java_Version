package org.example.bfsDfs;

import java.io.*;
import java.util.*;

public class Bj2667 {

    static int N;
    static int[][] map;
    static int houseCount;

    // 상하좌우 이동을 위한 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int totalComplexCount = 0;
        List<Integer> complexSizes = new ArrayList<>();

        // 지도 전체를 순회하며 단지 찾기
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 아직 방문하지 않은 집('1')을 발견하면 새로운 단지 시작
                if (map[r][c] == 1) {
                    houseCount = 0;

                    dfs(r, c);

                    totalComplexCount++;
                    complexSizes.add(houseCount);
                }
            }
        }

        Collections.sort(complexSizes);

        StringBuilder sb = new StringBuilder();
        sb.append(totalComplexCount).append("\n"); // 총 단지 수 출력

        for (int size : complexSizes) {
            sb.append(size).append("\n"); // 각 단지 크기 출력
        }

        System.out.print(sb.toString());
    }


    public static void dfs(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N || map[r][c] == 0) {
            return;
        }

        map[r][c] = 0;
        houseCount++;

        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i]);
        }
    }
}

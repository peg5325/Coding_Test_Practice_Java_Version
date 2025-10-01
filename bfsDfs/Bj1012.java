package org.example.bfsDfs;

import java.io.*;
import java.util.*;

public class Bj1012 {

    static int[][] field; // 배추밭
    static int M, N;

    // 상하좌우 이동을 위한 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            // N행 M열의 밭 초기화
            field = new int[N][M];

            // K개의 배추 위치 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()); // 가로(열) 인덱스
                int r = Integer.parseInt(st.nextToken()); // 세로(행) 인덱스
                field[r][c] = 1;
            }

            int count = 0; // 필요한 지렁이(연결 요소) 개수

            // 밭 전체를 순회하며 탐색
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    // 현재 위치에 배추가 있다면 (field[r][c] == 1)
                    if (field[r][c] == 1) {
                        dfs(r, c); // DFS로 연결된 모든 배추 방문 처리
                        count++;   // 새로운 군집을 찾았으므로 카운트 증가
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void dfs(int r, int c) {
        // 1. 종료 조건 및 경계 체크
        // 밭 경계를 벗어나거나, 현재 위치에 배추가 없다면 (0이라면) 종료
        if (r < 0 || r >= N || c < 0 || c >= M || field[r][c] == 0) {
            return;
        }

        // 2. 방문 처리 (배추를 수확했다고 간주)
        field[r][c] = 0;

        // 3. 상하좌우 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            // 재귀 호출
            dfs(nextR, nextC);
        }
    }
}


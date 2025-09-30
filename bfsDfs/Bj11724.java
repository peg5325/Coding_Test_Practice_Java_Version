package org.example.bfsDfs;

import java.io.*;
import java.util.*;

public class Bj11724 {

    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder inputBuffer = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            inputBuffer.append(line).append(" ");
        }

        StringTokenizer st = new StringTokenizer(inputBuffer.toString());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트 및 방문 배열 초기화
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 간선 정보 입력 (M번 반복)
        for (int i = 0; i < M; i++) {
            if (!st.hasMoreTokens()) break;
            int u = Integer.parseInt(st.nextToken());

            if (!st.hasMoreTokens()) break;
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가
            adj[u].add(v);
            adj[v].add(u);
        }

        int count = 0; // 연결 요소의 개수

        // 모든 정점을 순회하며 연결 요소 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }


    public static void dfs(int v) {
        visited[v] = true;

        for (int next : adj[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

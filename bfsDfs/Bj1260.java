package org.example.bfsDfs;

import java.io.*;
import java.util.*;

public class Bj1260 {

    // 그래프를 인접 리스트로 표현
    static List<Integer>[] adj;
    // 방문 여부 배열
    static boolean[] visited;
    // 결과를 저장할 StringBuilder
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        // 인접 리스트 초기화 (1번부터 N번까지 사용)
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선 추가
            adj[u].add(v);
            adj[v].add(u);
        }

        // 번호가 작은 것부터 방문하기 위해 인접 리스트 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        // 1. DFS 실행
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // 2. BFS 실행 (visited 배열 초기화 필수)
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb.toString());
    }


    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int next : adj[v]) {
            if (!visited[next]) {
                dfs(next); // 재귀 호출
            }
        }
    }


    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            sb.append(u).append(" ");

            for (int next : adj[u]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
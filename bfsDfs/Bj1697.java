package org.example.bfsDfs;

import java.io.*;
import java.util.*;

public class Bj1697 {

    // 최대 위치 (100,000. 경계를 벗어나지 않도록 100,001로 설정)
    // time[i] = 시작 위치 N에서 i 위치까지 가는 데 걸리는 최소 시간

    static final int MAX = 100000;
    static int[] time = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        // 시작점과 도착점이 같은 경우 0초
        if (N == K) {
            System.out.println(0);
            return;
        }

        // BFS 시작
        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 위치를 큐에 넣고 시간(0) 기록
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 이동 가능한 세 가지 다음 위치 배열
            // {X-1, X+1, 2*X}
            // 1. 범위 체크: 0 이상, MAX 이하인지 확인
            // 2. 방문 여부 체크: 아직 방문하지 않은 위치라면 (시간이 0이라면)
            // 3. 시간 기록: 현재 시간 + 1초
            // 4. 동생 위치에 도착했는지 확인
            // 5. 큐에 추가

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX) {

                    if (time[next] == 0) {
                        time[next] = time[current] + 1;

                        if (next == K) {
                            return time[next];
                        }

                        queue.offer(next);
                    }
                }
            }
        }
        // K에 도달하지 못하는 경우
        // 하지만 그럴 일은 없을 듯
        return -1;
    }
}

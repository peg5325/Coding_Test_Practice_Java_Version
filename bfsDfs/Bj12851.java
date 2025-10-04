package org.example.bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj12851 {

    // 최대 위치 (100,000)
    // time[i]: 시작 위치 N에서 i까지 가는 최소 시간. -1은 미방문 상태
    // count[i]: 최소 시간 time[i]로 i까지 가는 경로의 수


    static final int MAX = 100000;

    static int[] time = new int[MAX + 1];
    static int[] count = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        // time 배열을 -1로 초기화하여 미방문 상태 표시
        Arrays.fill(time, -1);

        // 시작점과 도착점이 같은 경우
        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs(N);

        // 결과 출력
        System.out.println(time[K]);
        System.out.println(count[K]);
    }

    public static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작점 초기화
        queue.offer(N);
        time[N] = 0;
        count[N] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 이동 가능한 세 가지 다음 위치
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                // 범위 체크
                if (next >= 0 && next <= MAX) {

                    // next를 처음 방문하는 경우 (최단 경로 발견)
                    if (time[next] == -1) {
                        time[next] = time[current] + 1;
                        count[next] = count[current];
                        queue.offer(next);
                    }
                    // next까지의 최소 시간과 같은 시간에 다시 도달한 경우 (또 다른 최단 경로 발견)
                    else if (time[next] == time[current] + 1) {
                        count[next] += count[current];  // 경로의 수만 누적
                    }
                }
            }
        }
    }
}

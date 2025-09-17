package org.example.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2578 {
    static int[][] board = new int[5][5];
    static boolean[][] marked = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자가 부르는 숫자 입력
        int count = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                count++;
                markNumber(num);

                if (countBingo() >= 3) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    // 숫자 체크하기
    private static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    // 현재 빙고 줄 개수 세기
    private static int countBingo() {
        int bingo = 0;

        // 가로 체크
        for (int i = 0; i < 5; i++) {
            boolean complete = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    complete = false;
                    break;
                }
            }
            if (complete) bingo++;
        }

        // 세로 체크
        for (int j = 0; j < 5; j++) {
            boolean complete = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    complete = false;
                    break;
                }
            }
            if (complete) bingo++;
        }

        // 대각선 체크 (왼쪽 위 → 오른쪽 아래)
        boolean complete = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                complete = false;
                break;
            }
        }
        if (complete) bingo++;

        // 대각선 체크 (오른쪽 위 → 왼쪽 아래)
        complete = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                complete = false;
                break;
            }
        }
        if (complete) bingo++;

        return bingo;
    }
}


package org.example.bruteForce;

import java.io.*;
import java.util.Arrays;

public class Bj2309 {
    public static void main(String[] args) throws IOException {
        // 아홉 명의 난쟁이 키를 입력 받음 (1 ~ 100)
        // 여기서 일곱 난쟁이를 정해야하고, 일곱 난쟁이 키의 합은 100
        // 일곱 난쟁이를 찾아서 오름차순으로 출력
        // 입력 받아 배열에 넣고 sum값을 구함 -> 오름차순 정렬
        // 이중 반복문을 통해서 9명 중 2명을 선정해서 sum 값에서 빼기
        // 2명의 키를 뺏을 때 100이 되면, 그 두명의 값을 저장 후 출력할 때 건너뛸 수 있도록 설

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    // 반복문을 바로 탈출하기 위함.
                    i = arr.length;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}

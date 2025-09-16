package org.example.simulation;

import java.io.*;
import java.util.*;

public class Bj20546 {
    public static void main(String[] args) throws IOException {
        // 준현이(j) = BNP 전략
        // 한 번 산 주식은 절대 팔지 않음.
        // 살 수 있다면 가능한 만큼 즉시 매수.
        // 가진 현금, 매수한 주식의 수 만 있으면 됨.

        // 성민이(s) = 33 매매법
        // 모든 거래는 전량 매수/전량 매도
        // 주가가 3일째 상승한다면, 전량 매도, 단, 전일과 오늘 주가가 동일하면 상승X
        // 주가가 3일 연속 하락한다면, 전량 매수, 이또한, 전일과 오늘 주가가 동일하면 하락X
        // 가진 현금, 매수한 주식의 수, 3일간 가격이 오르는지 안오르는지 파악할 게 필요.

        // 가진 현금 = cash
        // 주어지는 14일간의 주가 = stock[14]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // BNP
        int cashBNP = N, stockBNP = 0;
        for (int price : prices) {
            if (cashBNP >= price) {
                stockBNP += cashBNP / price;
                cashBNP %= price;
            }
        }
        int assetBNP = cashBNP + stockBNP * prices[13];

        // TIMING
        int cashTIM = N, stockTIM = 0;
        for (int i = 3; i < 14; i++) {
            // 3일 연속 상승
            if (prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1] && cashTIM > 0) {
                cashTIM += stockTIM * prices[i];
                stockTIM = 0;
            }
            // 3일 연속 하락
            else if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1] && stockTIM == 0) {
                stockTIM += cashTIM / prices[i];
                cashTIM %= prices[i];
            }
        }
        int assetTIM = cashTIM + stockTIM * prices[13];

        // 결과 출력
        if (assetBNP > assetTIM) System.out.println("BNP");
        else if (assetBNP < assetTIM) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}

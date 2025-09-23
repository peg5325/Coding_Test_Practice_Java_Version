package org.example.search;

import java.io.*;
import java.util.*;

public class Bj7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());

        HashSet<String> list = new HashSet<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                list.add(name);
            } else {
                list.remove(name);
            }
        }
        ArrayList<String> resultList = new ArrayList<>(list);

        Collections.sort(resultList, Collections.reverseOrder());

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String name : resultList) {
            sb.append(name).append("\n");
        }
        System.out.print(sb.toString());
    }
}

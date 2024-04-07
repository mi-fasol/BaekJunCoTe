import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] keyword = new String[n];
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            keyword[i] = st.nextToken();
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            int s = Integer.parseInt(br.readLine());

            int start = 0;
            int end = n - 1;
            int mid;
            while (start <= end) {
                mid = (start + end) / 2;
                if (s <= score[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            sb.append(keyword[start]).append("\n");
        }
        System.out.println(sb);
    }
}
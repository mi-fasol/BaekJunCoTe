import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cards;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++){
            pq.add(cards[i]);
        }

        int sum = 0;

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            sum += a + b;

            pq.add(a + b);
        }

        System.out.println(sum);
    }
}
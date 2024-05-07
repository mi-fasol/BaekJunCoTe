import java.io.*;
import java.util.*;

public class Main {

    static int N, W, L, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        int weight = 0;

        for(int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        while(!truck.isEmpty()) {
            time++;
            weight -= bridge.poll();

            if(weight + truck.peek() <= L) {
                weight += truck.peek();
                bridge.offer(truck.poll());

                if(truck.isEmpty()) {
                    time += W;
                    break;
                }
            } else {
                bridge.offer(0);
            }
        }

        System.out.println(time);
    }
}
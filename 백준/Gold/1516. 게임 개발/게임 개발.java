import java.io.*;
import java.util.*;

public class Main {
    static int N, firstBuilding;
    static ArrayList<ArrayList<int[]>> building = new ArrayList<>();
    static int[] time, rank, builtTime;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        rank = new int[N + 1];
        builtTime = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            building.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            if (next == -1) {
                firstBuilding = i;
                continue;
            }
            while (true) {
                building.get(next).add(new int[]{i, time[i]});
                rank[i] += 1;
                next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
            }
        }

        typologySort();

        for (int i = 1; i <= N; i++) {
            System.out.println(builtTime[i]);
        }
    }

    public static void typologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (rank[i] == 0) {
                q.offer(i);
                builtTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < building.get(now).size(); i++) {
                int next = building.get(now).get(i)[0];
                int nextBuildingTime = building.get(now).get(i)[1];

                if (builtTime[next] < builtTime[now] + nextBuildingTime) {
                    builtTime[next] = builtTime[now] + nextBuildingTime;
                }

                rank[next] -= 1;
                if (rank[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, dist = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] isSelected;
    static List<int[]> allChicken = new ArrayList<>();

    static List<int[]> home = new ArrayList<>();
    static List<int[]> comb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) home.add(new int[]{i, j});
                else if (num == 2) allChicken.add(new int[]{i, j});
                map[i][j] = num;
            }
        }

        isSelected = new boolean[allChicken.size()];

        for(int i = 0; i < allChicken.size(); i++) {
           combination(i, 0);
        }

        System.out.println(dist);
    }

    public static void combination(int start, int count){
        if(count == M){
            int sum = 0;
            for(int[] h : home){
                int min = Integer.MAX_VALUE;
                for(int[] c : comb){
                    min = Math.min(min, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }
                sum += min;
            }
            dist = Math.min(dist, sum);
            return;
        }

        for(int i = start; i < allChicken.size(); i++){
            isSelected[i] = true;
            comb.add(allChicken.get(i));
            combination(i + 1, count + 1);
            isSelected[i] = false;
            comb.remove(allChicken.get(i));
        }
    }
}
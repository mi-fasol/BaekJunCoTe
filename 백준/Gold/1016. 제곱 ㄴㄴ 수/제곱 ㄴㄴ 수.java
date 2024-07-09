import java.io.*;
import java.util.*;

public class Main {
    static long min, max;
    static int count;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        check = new boolean[(int) (max - min + 1)];
        
        for(long i = 2; Math.pow(i, 2) <= max; i++) {
            long squareNum = (long) Math.pow(i, 2);
            long start = min % squareNum == 0 ? min / squareNum : min / squareNum + 1;
            for(long j = start; squareNum * j <= max; j++) {
                check[(int) (squareNum * j - min)] = true;
            }
        }

        for (boolean b : check) {
            if (!b) {
                count++;
            }
        }

        System.out.println(count);
    }
}
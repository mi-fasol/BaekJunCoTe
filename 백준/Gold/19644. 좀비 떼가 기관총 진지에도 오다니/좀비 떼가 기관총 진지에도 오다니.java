import java.io.*;
import java.util.*;

public class Main {
    static int L, Ml, Mk, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Ml = Integer.parseInt(st.nextToken());
        Mk = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(br.readLine());

        int[] zombies = new int[L];

        int start= -Ml + 1;
        int end = 0;

        // 70
        int fullDamage = Ml * Mk;
        int lastDistance = Ml - 1;

        boolean[] needAmmo = new boolean[L];

        while (true) {
            zombies[end] = Integer.parseInt(br.readLine());
            int damage = fullDamage - lastDistance * Mk;
            
            if (damage < zombies[end]) {
                if (C > 0) {
                    C--;
                    lastDistance++;
                    needAmmo[end] = true;
                } else {
                    System.out.println("NO");
                    return;
                }
            }

            if (start < 0 || needAmmo[start]) {
                lastDistance--;
            }

            start++;
            end++;

            if (end == L)
                break;
        }

        System.out.println("YES");
    }
}
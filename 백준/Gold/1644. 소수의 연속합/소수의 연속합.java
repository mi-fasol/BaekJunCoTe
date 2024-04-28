import java.io.*;
import java.util.*;

public class Main {
    static int N, CNT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<Integer> primeList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(checkIsPrime(i)) primeList.add(i);
        }

        int start = 0;
        int end = 0;

        if (primeList.size() == 0) {
            System.out.println(0);
            return;
        }

        while (start <= end && end < primeList.size()) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += primeList.get(i);
            }

            if (sum == N) {
                CNT++;
                start++;
                end = start;
            } else if (sum < N) {
                end++;
            } else {
                start++;
                end = start;
            }
        }
        System.out.println(CNT);
    }

    public static boolean checkIsPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
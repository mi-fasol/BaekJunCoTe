import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        changeRadix(m, n);
    }

    public static void changeRadix(int m, int n) {
        ArrayList<Integer> arr= new ArrayList<>();

        while(m > 0) {
            arr.add(m%n);
            m /= n;
        }
        
        if(arr.size() == 0) {
            System.out.println(0);
            return;
        }

        for(int i = arr.size()-1; i >= 0; i--) {
            if(arr.get(i) >= 10) {
                System.out.print((char)(arr.get(i) + 55));
            } else {
                System.out.print(arr.get(i));
            }
        }
    }
}
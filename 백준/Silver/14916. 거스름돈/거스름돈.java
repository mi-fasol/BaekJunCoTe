import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int cnt = 0;

        while(num > 0){
            if(num%5 == 0){
                num -= 5;
                cnt += 1;
            } else{
                num-= 2;
                cnt +=1;
            }
        }

        if(num != 0){
            System.out.println(-1);
        } else{
            System.out.println(cnt);
        }
    }
}
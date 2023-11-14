import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> bear = new Stack<>();

        int num = Integer.parseInt(br.readLine());

        int day = 0;
        int gualho = 0;

        String st = br.readLine();

        for (int i = 0; i < num; i++) {
            bear.push(st.charAt(i));
        }

        if(num%2==1){
            System.out.println(-1);
            return;
        }

        for(char i : bear){
            if (i == '('){
                gualho += 1;
            } else{
                gualho -= 1;
            }
            if (Math.abs(gualho) > day){
                day = Math.abs(gualho);
            }
        }

        bw.write(gualho == 0 ? Integer.toString(day) : "-1");

        br.close();
        bw.close();
    }
}
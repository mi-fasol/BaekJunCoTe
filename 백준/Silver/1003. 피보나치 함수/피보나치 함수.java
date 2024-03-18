import java.io.*;

public class Main {

    public static int zeroCnt = 0;
    public static int oneCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            fibonacci(Integer.parseInt(br.readLine()));
            System.out.println(zeroCnt + " " + oneCnt);
            zeroCnt = oneCnt = 0;
        }
    }

    public static void fibonacci(int num) {
        int tmp1 = 0;
        int tmp2 = 1;
        int tmp = 0;

        if (num == 0) {
            zeroCnt++;
        } else if (num == 1) {
            oneCnt++;
        }
        else{
            for(int i = 1; i < num; i++){
                tmp = tmp1 + tmp2;
                tmp1 = tmp2;
                tmp2 = tmp;
            }
            zeroCnt = tmp1;
            oneCnt = tmp2;
        }
    }
}
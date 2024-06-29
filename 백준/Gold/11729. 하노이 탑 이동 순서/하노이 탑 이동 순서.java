import java.io.*;

public class Main {
    static int N, count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        setHanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void setHanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            count++;
        } else {
            setHanoi(n - 1, start, end, mid);
            sb.append(start).append(" ").append(end).append("\n");
            count++;
            setHanoi(n - 1, mid, start, end);
        }
    }
}
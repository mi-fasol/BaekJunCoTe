import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bf.readLine());

        for (int i = 1; i < num + 1 ; i++){
            bw.write(" ".repeat(num-i) + "*".repeat(i) + "\n");

        }
        bw.close();
    }
}
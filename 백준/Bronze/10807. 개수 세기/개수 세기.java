import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < num; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int cntNum = Integer.parseInt(bf.readLine());

        System.out.println((Collections.frequency(list, cntNum)));

        bw.close();
    }
}
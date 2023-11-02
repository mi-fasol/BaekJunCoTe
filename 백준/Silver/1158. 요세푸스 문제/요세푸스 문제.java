import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= num; i++){
            q.offer(i);
        }

        System.out.print("<");

        while(q.size() != 1){
                for (int i = 0; i < k -1; i++){
                    q.offer(q.poll());
                }
                System.out.print(q.poll() + ", ");
            }
        System.out.println(q.poll()+">");

//        1 2 3 4 5 6 7
//        1 2 4 5 6 7
//        1 2 4 5 7
//        1 4 5 7
//        1 4 5
//        1 4
//        4
    }
}
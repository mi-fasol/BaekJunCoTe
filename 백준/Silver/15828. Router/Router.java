import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        while(true){
            int p = sc.nextInt();
            if (q.size() < num){
                if(p == -1) break;
                else if (p == 0 && !q.isEmpty()){
                    q.remove();
                } else{
                    q.offer(p);
                }
            }
        }

        if(!q.isEmpty()){
            while(!q.isEmpty()){
                System.out.print(q.poll() + " ");
            }
        } else{
            System.out.println("empty");
        }
    }
}
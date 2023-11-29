import java.io.*;
import java.util.*;

class Flower{
    int bloomingDay;
    int fallingDay;

    public Flower(int b, int f){
        this.bloomingDay = b;
        this.fallingDay = f;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int num = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int bloomingDay = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int fallingDay = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            flowers.add(new Flower(bloomingDay, fallingDay));
        }

        int now = 301;
        int numOfFlower = 0;

        while(true){
            if(now >= 1201){
                break;
            } else{
                int best = 0;

                for(int i = 0; i < flowers.size(); i++){
                    int b = flowers.get(i).bloomingDay;
                    int f = flowers.get(i).fallingDay;

                    if(now >= b){
                        if(best ==0 || best < f){
                            best = f;
                            flowers.remove(i);
                            i--;
                        }
                    }
                }

                if(best == 0){
                    bw.write("0");
                    bw.close();
                    br.close();
                    return;
                } else{
                    now = best;
                    numOfFlower++;
                }
            }
        }

        bw.write(String.valueOf(numOfFlower));
        bw.close();
        br.close();
    }
}
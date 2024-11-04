import java.util.*;
import java.io.*;

class Solution {
    static int res, max;
    static ArrayList<Data> list = new ArrayList<>();
    static class Data {
        public int total;
        public int diamond;
        public int iron;
        public int stone;

        public Data(int total, int diamond, int iron, int stone) {
            this.total = total;
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }

        public int getTotal() {
            return total;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        max = Arrays.stream(picks).sum()*5;

        if(minerals.length > max) {
            minerals = Arrays.copyOf(minerals, max);
        }

        makeGroup(minerals);

        list.sort(Comparator.comparingInt(Data::getTotal).reversed());

        for(Data data : list) {
            if(picks[0] > 0) {
                res += data.diamond + data.iron + data.stone;
                picks[0]--;
            } else if(picks[1] > 0) {
                res += data.diamond * 5 + data.iron + data.stone;
                picks[1]--;
            } else if(picks[2] > 0) {
                res += data.diamond * 25 + data.iron * 5 + data.stone;
                picks[2]--;
            } else break;
        }

        return res;
    }
    
   public static void makeGroup(String[] minerals) {
        for(int i = 0; i < minerals.length; i+=5) {
            int total = 0;
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            for (int j = 0; j < 5 && i + j < minerals.length; j++) {
                if(minerals[i+j].equals("diamond")) {
                    total += 25;
                    diamond++;
                } else if(minerals[i+j].equals("iron")) {
                    total += 5;
                    iron ++;
                } else {
                    total += 1;
                    stone ++;
                }
            }
            list.add(new Data(total, diamond, iron, stone));
        }
    }
}
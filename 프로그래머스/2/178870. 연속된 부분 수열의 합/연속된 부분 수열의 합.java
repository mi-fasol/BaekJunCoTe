import java.util.*;
import java.io.*;

class Solution {
    static int start, end, sum, n;
    static ArrayList<Data> list = new ArrayList<>();
    static class Data {
        int startIdx;
        int endIdx;
        int size;
        
        public Data(int startIdx, int endIdx) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.size = endIdx - startIdx;
        }
    }
    public int[] solution(int[] sequence, int k) {
        start = 0;
        end = 0;
        n = sequence.length;
        sum = sequence[0];
        
        while(start < n && end < n) {
            if(sum == k) {
                list.add(new Data(start, end));
            }

            if(sum <= k && end < n) {
                end++;
                if(end < n) sum += sequence[end];
            } else {
                if(start < n) sum -= sequence[start];
                start++;
            }
        }

        list.sort((a, b) -> {
            if(a.size == b.size) {
                return a.startIdx - b.startIdx;
            } else {
                return a.size - b.size;
            }
        });
        
        return new int[]{list.get(0).startIdx, list.get(0).endIdx};
    }
}
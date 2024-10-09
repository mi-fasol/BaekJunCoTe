import java.util.*;
import java.io.*;

class Solution {
    static int hMax, wMax;
    public int solution(int[][] size) {
        int answer = 0;
        
        for(int i = 0; i < size.length; i++) {
            if(size[i][0] > size[i][1]) {
                int tmp = size[i][0];
                size[i][0] = size[i][1];
                size[i][1] = tmp;
            }
        }
        
        for(int[] num: size){
            wMax = Math.max(wMax, num[0]);
            hMax = Math.max(hMax, num[1]);
        }
        
        return wMax * hMax;
    }
}
import java.util.*;
import java.io.*;

class Solution {
    static int res;
    static boolean isExist = false;
    static boolean[][] isChecked;
    public int solution(String begin, String target, String[] words) {
        isChecked = new boolean[words.length][words.length];
        
        for(String s : words) {
            if(s.equals(target)) {
                isExist = true;
                break;
            }
        }
        
        if(!isExist) return 0;
        
        bfs(begin, target, words);
        
        return res;
    }
    
    public static void bfs(String begin, String target, String[] words) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{-1, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int idx = now[0];
            int cnt = now[1];
            
            int diffCnt = 0;
            
            if(idx==-1) {
                for(int i = 0; i < target.length(); i++){
                    if(begin.charAt(i) != target.charAt(i)) {
                        diffCnt++;
                    }
                    if (diffCnt > 1) break; 
                }
            } else {
                for(int i = 0; i < target.length(); i++){
                    if(words[idx].charAt(i) != target.charAt(i)) {
                        diffCnt++;
                    }
                    if (diffCnt > 1) break; 
                }
            }
            
            
            if(diffCnt == 1) {
                res = cnt + 1;
                return;
            } else if(diffCnt == 0) {
                res = cnt;
                return;
            }
            
            for(int i = 0; i < words.length; i++) {
                diffCnt = 0;
                if(idx == -1) {
                    for(int j = 0; j < words[i].length(); j++){
                        if(begin.charAt(j) != words[i].charAt(j)) {
                            diffCnt++;
                        }
                        if (diffCnt > 1) break; 
                    }
                    if(diffCnt <= 1) {
                        q.offer(new int[]{i, cnt + 1});
                    }
                } else {
                    if(isChecked[idx][i] || idx == i) continue;
                for(int j = 0; j < words[i].length(); j++){
                    if(words[idx].charAt(j) != words[i].charAt(j)) {
                        diffCnt++;
                    }
                    if (diffCnt > 1) break; 
                }
                if(diffCnt <= 1) {
                    q.offer(new int[]{i, cnt+1});
                    isChecked[idx][i] = true;
                }
                }
            }
        }
        return;
    }
}
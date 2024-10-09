import java.util.*;
import java.io.*;

class Solution {
    static Character[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        return list.indexOf(word);
    }
    
    public static void dfs(String now) {
        if(now.length() > 5) {
            return;
        }
        
        list.add(now);
        for(int i = 0; i < alphabet.length; i++) {
            dfs(now+alphabet[i]);
        }
    }
}
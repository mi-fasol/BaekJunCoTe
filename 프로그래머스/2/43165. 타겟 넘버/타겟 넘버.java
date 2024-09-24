import java.io.*;
import java.util.*;

class Solution {
    static int N, num;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        num = target;
        
        return dfs(numbers, 0, 0);
    }
    
    public static int dfs(int[] numbers, int sum, int idx) {
        if(idx == N) {
            return sum == num ? 1 : 0;
        }
        
        return dfs(numbers, sum + numbers[idx], idx+1) + dfs(numbers, sum - numbers[idx], idx+1);
    }
}
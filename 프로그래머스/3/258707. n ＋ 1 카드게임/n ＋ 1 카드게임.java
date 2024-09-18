import java.util.*;
import java.io.*;

class Solution {
    static boolean[] isUsed;
    static int N, target, round = 1, coinCnt;
    static List<Integer> cardList = new ArrayList<>();
    public int solution(int coin, int[] cards) {
        N = cards.length;
        target = N+1;
        coinCnt = coin;
        isUsed = new boolean[N];
        
        for(int i = 0; i < N / 3; i++) {
            cardList.add(cards[i]);
        }
    
        for (int i = N / 3; i < N; i += 2) {
            cardList.add(cards[i]);
            cardList.add(cards[i+1]);
            
            if(coinCnt < 0 || !canGoNext(cards)) {
                return round;
            }
            
            round++;
        }
        
        
        return round;
    }
    
    public static boolean canGoNext(int[] cards) {
         for (int i = 0; i < N / 3; i++) {
            for (int j = i + 1; j < N / 3; j++) {
                if(isUsed[i] || isUsed[j]) continue;
                if(cardList.get(i) + cardList.get(j) == target) {
                    isUsed[i] = true;
                    isUsed[j] = true;
                    return true;
                }
            }
        }

        for (int i = 0; i < cardList.size() - 1; i++) {
            for (int j = i + 1; j < cardList.size(); j++) {
                if(isUsed[i] || isUsed[j]) continue;
                if (cardList.get(i) + cardList.get(j) == target) {
                    isUsed[i] = true;
                    isUsed[j] = true;
                    if (i >= N / 3) {
                        coinCnt--;
                    }
                    if (j >= N / 3) {
                        coinCnt--;
                    }
                    return coinCnt >= 0;
                }
            }
        }
        
        return false;
    }
}
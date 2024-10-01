import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, ArrayList<String>> maps = new HashMap<>();
    static HashMap<String, Integer> ticketCount = new HashMap<>();
    static ArrayList<String> c = new ArrayList<>();
    static boolean[][][] visited;
    static ArrayList<String[]> way = new ArrayList<>();
    static String[] answer;
    static int N;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length + 1;
        for (String[] ticket : tickets) {
            for (String t : ticket) {
                if (!c.contains(t)) c.add(t);
            }
        }

        for (String[] ticket : tickets) {
            if (!maps.containsKey(ticket[0])) {
                maps.put(ticket[0], new ArrayList<>());
            }
            if (maps.get(ticket[0]).contains(ticket[1])) {
                ticketCount.put(ticket[0] + ticket[1], ticketCount.get(ticket[0] + ticket[1]) + 1);
            } else {
                ticketCount.put(ticket[0] + ticket[1], 1);
            }
            maps.get(ticket[0]).add(ticket[1]);
        }

        answer = new String[N];
        visited = new boolean[N][N][N];

        dfs("ICN", new ArrayList<>(List.of("ICN")));
        Collections.sort(way, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i].compareTo(b[i]) != 0) return a[i].compareTo(b[i]);
            }
            return 0;
        });
        
        return way.get(0);
    }
    
    public static void dfs(String now, ArrayList<String> lines) {
        if (lines.size() == N) {
            for (int i = 0; i < N; i++) {
                answer[i] = lines.get(i);
            }
            way.add(answer.clone());
            return;
        }

        if (maps.containsKey(now)) {
            for (String next : maps.get(now)) {
                int idx = c.indexOf(now);
                int nextIdx = c.indexOf(next);
                if(ticketCount.get(now+next) > 0 && !visited[idx][nextIdx][ticketCount.get(now+next)]) {
                    visited[idx][nextIdx][ticketCount.get(now+next)] = true;
                    ticketCount.put(now+next, ticketCount.get(now+next)-1);
                    lines.add(next);
                    dfs(next, lines);
                    lines.remove(lines.size()-1);
                    ticketCount.put(now+next, ticketCount.get(now+next)+1);
                    visited[idx][nextIdx][ticketCount.get(now+next)] = false;
                }
            }
        }
    }
}
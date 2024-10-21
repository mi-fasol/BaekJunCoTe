import java.util.*;
import java.io.*;

class Solution {
    static Stack<Pair> stop = new Stack<>();
    static int[] startTime, endTime;
    static HashMap<Integer, String> work = new HashMap<>();
    static String[] res;
    static class Pair {
        String name;
        int remainTime;

        public Pair(String name, int remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        res = new String[plans.length];
        startTime = new int[plans.length];
        endTime = new int[plans.length];
        Arrays.sort(plans, (a, b) -> makeTime(a[1]) - makeTime(b[1]));
        int idx = 0;

        for(String[] p : plans) {
            work.put(makeTime(p[1]), p[0]);
            startTime[idx] = makeTime(p[1]);
            endTime[idx++] = makeTime(p[1]) + Integer.parseInt(p[2]);
        }
        makeLine(plans.length);
        return res;
    }

    public static Integer makeTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        return hour * 60 + minute;
    }
    
public static void makeLine(int size) {
        int cnt = 1, idx = 0;
        String now = "";
        String next = "";
        int start = 0;
        int end = 0;

        while(cnt < size) {
            now = work.get(startTime[cnt-1]);
            next = work.get(startTime[cnt]);
            start = startTime[cnt];
            end = endTime[cnt-1];

            if (end > start) {
                stop.push(new Pair(now, end - start));
            } else {
                res[idx++] = now;
                while(!stop.isEmpty()) {
                    Pair top = stop.peek();
                    if(top.remainTime > start - end) {
                        top.remainTime -= start - end;
                        break;
                    } else if(top.remainTime == start - end) {
                        res[idx++] = top.name;
                        stop.pop();
                        break;
                    } else {
                        res[idx++] = top.name;
                        stop.pop();
                        end += top.remainTime;
                    }
                }
            }

            cnt++;
            if(cnt == size) {
                res[idx++] = next;
            }
        }

        while(!stop.isEmpty()) {
            res[idx++] = stop.pop().name;
        }
    }
}
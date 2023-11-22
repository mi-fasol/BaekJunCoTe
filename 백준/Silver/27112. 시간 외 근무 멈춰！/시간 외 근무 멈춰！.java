import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Job> jobs = new PriorityQueue<>(((o1, o2) -> o1.d - o2.d));

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            jobs.add(new Job(day, time));
        }

        int result = 0;
        int limit = 0;
        int workDay = 0;

        while (!jobs.isEmpty()) {

            Job job = jobs.poll();

            limit = job.d;
            limit -= (job.d / 7) * 2;

            if (job.d % 7 == 6) limit--;

            workDay += job.t;

            if (workDay > limit) {
                result += workDay - limit;

                workDay = limit;
            }

            if (result > job.d) {
                result = -1;
                break;
            }

        }

        System.out.println(result);
        br.close();

    }

    static class Job {
        int d;
        int t;

        public Job(int d, int t) {
            this.d = d;
            this.t = t;
        }
    }
}
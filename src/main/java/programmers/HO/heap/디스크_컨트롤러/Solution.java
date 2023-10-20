package programmers.HO.heap.디스크_컨트롤러;

import java.util.PriorityQueue;

class Solution {

    private static class Job {
        private int start;
        private int cost;

        public Job(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }

        public int getStart() {
            return start;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int cost = 0;
        int count = 0;
        int waitTime = 0;
        int costTime = 0;

        PriorityQueue<Job> wait = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        PriorityQueue<Job> ready = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        //wait queue 값 세팅
        for (int[] job : jobs) {
            wait.add(new Job(job[0], job[1]));
        }

        while (count < jobs.length) {
            while (!wait.isEmpty() && wait.peek().getStart() <= costTime) {
                ready.add(wait.poll());
            }

            if (!ready.isEmpty()) {
                Job job = ready.poll();
                cost += job.getCost();
                count++;

                System.out.println("job.getStart() = " + job.getStart());
                System.out.println("job.getCost() = " + job.getCost());
            } else {
                Job job = wait.poll();

                costTime += job.getCost();
                waitTime += cost - job.getStart();
                job.setCost(job.getCost() + waitTime);
                ready.add(job);
            }
        }

        answer = getAnswer(cost, jobs.length);
        return answer;
    }

    private static int getAnswer(int cost, int jobSize) {
        return cost / jobSize;
    }

    public static void main(String[] args) {
        int[][] jobs = {
            {0, 3}, {2, 6}, {1, 9}
        };
        int solution = solution(jobs);
        System.out.println("solution = " + solution);
    }
}
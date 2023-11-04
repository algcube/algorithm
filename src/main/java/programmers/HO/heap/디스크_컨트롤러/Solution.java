package programmers.HO.heap.디스크_컨트롤러;

import java.util.PriorityQueue;

class Solution {

    private class Job {
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
    }

    public int solution(int[][] jobs) {
        int count = 0;
        int waitTime = 0; // 다른 CPU를 기다리는 시간
        int costTime = 0;
        int idle = 0; // CPU 가 어떠한 작업도 하지 않을 때 다음 CPU 사용을 기다리는 시간

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
                waitTime += costTime - job.getStart();
                costTime += job.getCost();
                count++;
            } else {
                idle += wait.peek().getStart() - costTime;
                costTime = wait.peek().getStart();
            }
        }

        return getAnswer(waitTime, costTime, idle, jobs.length);
    }

    public int getAnswer(int waitTime, int costTime, int idle, int jobsLength) {
        return (waitTime + costTime - idle) / jobsLength;
    }
}

package programmers.모의고사;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /**
     * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
     * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
     * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     */
    public int[] solution(int[] answers) {
        List<Person> people = List.of(
                new Person(new LinkedList<>(List.of(1, 2, 3, 4, 5)), 0),
                new Person(new LinkedList<>(List.of(2, 1, 2, 3, 2, 4, 2, 5)), 0),
                new Person(new LinkedList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)), 0)
        );
        for (int answer : answers) {
            for (Person person : people) {
                Integer num = person.queue.poll();
                if (num == answer) person.score += 1;
                person.queue.add(num);
            }
        }
        int maxScore = Integer.MIN_VALUE;
        for (Person person : people) {
            maxScore = Math.max(maxScore,person.score);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < people.size(); i++ ){
            if (people.get(i).score == maxScore){
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    class Person{

        private Queue<Integer> queue;

        private int score;

        public Person(Queue<Integer> queue, int score) {
            this.queue = queue;
            this.score = score;
        }
    }
}
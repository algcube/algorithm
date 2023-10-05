package programmers.베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Pair>> map = new HashMap();
        for (int i = 0; i < plays.length; i++) {
            Pair pair = new Pair(i, plays[i]);
            if (map.containsKey(genres[i])) {
                List<Pair> pairs = map.get(genres[i]);
                pairs.add(pair);
                continue;
            }
            List<Pair> pairs = new ArrayList<>();
            pairs.add(pair);
            map.put(genres[i], pairs);
        }
        for (String key : map.keySet()) {
            List<Pair> pairs = map.get(key);
            if (pairs.size() == 1) {
                continue;
            }
            pairs.sort(Pair::compareTo);
        }

        return map.values().stream()
                .sorted(Comparator.comparingLong(this::getSum))
                .map((pairs) -> {
                    if (pairs.size() > 1) {
                        return List.of(pairs.get(0), pairs.get(1));
                    }
                    return pairs;
                })
                .flatMap(Collection::stream)
                .mapToInt(Pair::getIndex)
                .toArray();
    }

    private long getSum(List<Pair> pairs) {
        return pairs.stream().map(Pair::getValue).reduce(Long::sum).get() * -1;
    }


    private class Pair implements Comparable<Pair> {
        private final int index;
        private final long value;

        private Pair(int index, long value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public long getValue() {
            return value;
        }

        @Override
        public int compareTo(Pair o) {
            // 점수 내림차순으로 비교
            int result = Long.compare(this.value, o.value) * -1;
            if (result == 0) {
                // 점수 같은 경우 인덱스를 오름차순으로 비교
                return Integer.compare(this.index, o.index);
            }
            return result;
        }
    }
}
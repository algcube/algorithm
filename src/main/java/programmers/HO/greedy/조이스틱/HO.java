package programmers.HO.greedy.조이스틱;

class Solution {

    //26개
    private final static char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public int solution(String name) {
        int answer = 0;
        int minLeftRight = clickRight(name.length());

        for (int i = 0; i < name.length(); i++) {
            int minUpDown = Math.min(clickUp(name.charAt(i)), clickDown(name.charAt(i)));
            answer += minUpDown;

            //A 갯수 카운트
            int countA = i +1;
            while (countA < name.length() && name.charAt(countA) == 'A') {
                countA++;
            }
            minLeftRight = Math.min(minLeftRight, clickRightAndLeft(name.length(), countA, i));
            minLeftRight = Math.min(minLeftRight, clickLeftAndRight(name.length(), countA, i));
        }
        answer += minLeftRight;
        return answer;
    }

    private int clickRight(int nameLength) {
        return nameLength -1;
    }

    private int clickLeftAndRight(int nameLength, int countA, int i) {
        return (nameLength - countA) * 2 + i;
    }

    private int clickRightAndLeft(int nameLength, int countA, int i) {
        return (i * 2) + nameLength - countA;
    }

    private int clickUp(char name) {
        int count =0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == name) {
                break;
            }
            count++;
        }
        return count;
    }

    private int clickDown(char name) {
        int count =0;
        for (int i = 0; i >= 0 ; i--) {
            if (charArray[i] == name) {
                break;
            }
            count++;

            // 처음에 "A"부터 시작
            if (i == 0) {
                i = 26;
            }
        }
        return count;
    }
}
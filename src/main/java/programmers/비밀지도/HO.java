package programmers.비밀지도;

class Solution {

    private final static String WALL = "1";
    private final static String REPLACE_WALL = "#";
    private final static String EMPTY = "0";
    private final static String REPLACE_EMPTY = " ";

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);
            String[] binaryArr1 = addZero(binary1, n);
            String[] binaryArr2 = addZero(binary2, n);

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binaryArr1[j].equals(WALL) || binaryArr2[j].equals(WALL)) {
                    sb.append(REPLACE_WALL);
                } else {
                    sb.append(REPLACE_EMPTY);
                }
            }

            result[i] = sb.toString();
        }

        return result;
    }

    private String[] addZero(String binary, int n) {

        // "0"을 추가해야하는 개수만큼 추가
        if (binary.length() < n) {
            int zeroCount = n - binary.length();
            for (int i = 0; i < zeroCount; i++) {
                StringBuilder sb = new StringBuilder(binary);
                sb.insert(0, EMPTY);
                binary = sb.toString();
            }
        }
        return binary.split("");
    }
}

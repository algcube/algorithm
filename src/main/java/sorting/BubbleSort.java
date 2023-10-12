package sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class BubbleSort {

    public static void main(String[] args) {

        Random random = new Random();
        int[] input = IntStream.range(0, 34)
                .map((i) -> random.nextInt(999))
                .toArray();

        System.out.println("Arrays.toString(input) = " + Arrays.toString(input));
        insertionSort(input);
        System.out.println("Arrays.toString(input) = " + Arrays.toString(input));
    }

    private static void selectionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = i; j < input.length; j++) {
                if (input[j] < min) {
                    min = input[j];
                    minIndex = j;
                }
            }
            swap(input, minIndex, i);
        }
    }

    private static void bubbleSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = input.length - 1; j > i; j--) {
                if (input[j - 1] > input[j]) {
                    swap(input, j - 1, j);
                }
            }
        }
    }

    private static void insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            for (int j = i; j - 1 >= 0; j--) {
                // 작거나 같다면 shift 연산을 수행하지 않아도됨.
                if (input[j - 1] <= current) {
                    break;
                }
                // shift연산 수행
                input[j] = input[j - 1];
                // 삽입위치를 찾았다면 값을 넣어준다.
                if (input[j - 1] > current || j - 1 == 0) {
                    input[j - 1] = current;
                }
            }
        }
    }

    private static void quickSort(int[] input) {
        int pivot = input.length / 2;

        int start = 0;
        int end = input.length - 1;

        while (true){
            if (start == end){

            }
            while (input[start] < input[pivot] && start < input.length && start <= end) {
                start++;
            }
            while (input[end] > input[pivot] && end >= 0 && end >= start) {
                end--;
            }
        }

    }

    private static void swap(int[] input, int x, int y) {
        int tmp = input[x];
        input[x] = input[y];
        input[y] = tmp;
    }
}

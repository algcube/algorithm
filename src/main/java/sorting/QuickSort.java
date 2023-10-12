package sorting;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 4, 6, 8, 7, 1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("정렬된 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // 피벗을 가장 왼쪽 값으로 선택
        int start = low;
        int end = high;

        while (start < end) {
            while (arr[start] <= pivot && start < high) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }

        // 피벗과 end 지점의 값을 교환
        swap(arr, low, end);

        // 피벗이 위치한 인덱스 반환
        return end;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

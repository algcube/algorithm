package ch05_DFS_BFS.factorial_예제;

public class HO {
    public static void main(String[] args) {
        int factorialIterative = factorialIterative(5);
        int factorialRecursive = factorialRecursive(5);

        System.out.println("factorialIterative = " + factorialIterative);
        System.out.println("factorialRecursive = " + factorialRecursive);
    }

    //재귀
    private static int factorialRecursive(int param) {
        if (param ==1) return param;
        return param * factorialRecursive(param -1);
    }

    //반복
    private static int factorialIterative(int param) {
        int result = 1;
        for (int i = 1; i <= param; i++) {
            result *= i;
        }
        return result;
    }
}

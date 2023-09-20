package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CS_14888 {

    public static final int ADD = 0;
    public static final int MINUS = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVIDE = 3;
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] operators = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dfs(input,operators ,input[0] ,1);
        System.out.println(maxValue +"\n" + minValue);
    }

    private static void dfs(int[] input,  int[] operators , int value , int curr){
        if (curr == input.length){
            maxValue = Math.max(maxValue,value);
            minValue = Math.min(minValue,value);
            return;
        }
        if (operators[ADD] > 0){
            applyOperation(input,operators,ADD,value + input[curr],curr);
        }
        if (operators[MINUS] > 0){
            applyOperation(input,operators,MINUS,value - input[curr],curr);
        }
        if (operators[MULTIPLY] > 0){
            applyOperation(input,operators,MULTIPLY,value * input[curr],curr);
        }
        if (operators[DIVIDE] > 0){
            applyOperation(input,operators,DIVIDE,value / input[curr],curr);
        }
    }

    private static void applyOperation(int[] input , int[] operators , int operator , int calculate , int curr){
        operators[operator]-=1;
        dfs(input, operators , calculate , curr+1);
        operators[operator]+=1;
    }
}
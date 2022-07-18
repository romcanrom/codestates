package coplit.recursion;

import java.util.Arrays;

public class RecursionPractice {
    public static void main(String[] args) {
        RecursionPractice r = new RecursionPractice();

        System.out.println(r.sumTo(10));
        System.out.println(r.factorial(10));
        System.out.println(r.fibonacci(9));

    }



    //1부터 n까지의 합 구하기
    public int sumTo(int num){
        if(num==0) return 0;
        return num + sumTo(num-1);
    }

    //홀수면 true, 짝수면 false
    public boolean isOdd(int num){
        if(num<0) num = -num;
        if(num==1) return true;
        if(num==2) return false;
        return isOdd(num-2);
    }

    //팩토리얼 값 반환
    public int factorial(int num){
        if(num==0) return 1;
        return num * factorial(num-1);
    }

    //피보나치
    public int fibonacci(int num){
        if(num<=1) return num;
        return fibonacci(num-1) + fibonacci(num-2);
    }

    //배열의 모든 요소의 합
    public int arrSum(int[] arr){
        if(arr.length==0) return 0;
        return arr[0] + arrSum(Arrays.copyOfRange(arr, 1, arr.length));
    }

    //배열의 모든 요소의 곱
    public int arrProduct(int[] arr){
        if(arr.length==0) return 1;
        return arr[0] * arrProduct(Arrays.copyOfRange(arr, 1, arr.length));
    }

    //배열의 길이
    public int arrLength(int[] arr){
        if(arr.length==0) return 0;
        return 1 + arrLength(Arrays.copyOfRange(arr, 1, arr.length));
    }

    //n개의 요소가 제거된 새로운 배열
    public int[] drop(int num, int[] arr){
        if(num==0 || arr.length==0) return arr;
        return drop(num-1, Arrays.copyOfRange(arr, 1, arr.length));
    }

    //n개의 요소만 포함된 새로운 배열
    public int[] take(int num, int[] arr){
        if(arr.length==0 || num==0) return new int[]{};
        if(num==arr.length || num>arr.length) return arr;
        return take(num, Arrays.copyOfRange(arr, 0, arr.length-1));
    }
    public int[] take2(int num, int[] arr){
        //base case
        if(arr.length==0 || num==0) return new int[]{};
        //recursive case
        int[] head = Arrays.copyOfRange(arr, 0, 1);
        int[] tail = take(num-1, Arrays.copyOfRange(arr, 1, arr.length));
        int[] dest = new int[head.length+tail.length];
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);

        return dest;
    }




}

package coplit.algorithm;

import java.util.Arrays;

public class BruteForce {
    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 5, 3, 8};
        int K = 8;
        System.out.println(Arrays.toString(SelectionSort(arr)));
    }
    static boolean SequentialSearch(int[] arr, int K){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==K) return true;
        }
        return false;
    }

    static boolean BruteForceStringMatch(int[] arr, int[] patternArr ){
        int arrLen = arr.length;
        int patternLen = patternArr.length;

        for(int i=0; i<arrLen-patternLen; i++){
            int j = 0;
            while(j < arrLen && patternArr[j]==arr[i+j]) j=j+1;
            if(j==patternLen) return true;
        }
        return false;
    }

    static int[] SelectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min]) min=j;
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        return arr;
    }
}
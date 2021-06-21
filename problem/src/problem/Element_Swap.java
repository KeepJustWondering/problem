package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Element_Swap {
    public static void main(String[] args){
        Element_Swap result = new Element_Swap();
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for(int i=0;i<N;i++)
            A[i]=input.nextInt();
        for(int i=0;i<N;i++)
            B[i]=input.nextInt();

        System.out.println(result.sum(A,B,N,K));
    }
    private int sum(int[] A,int[] B,int N,int K){
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=N-1;i>K-1;i--)
            sum += A[i];
        for(int i=N-1;i>N-K-1;i--)
            sum += B[i];

        return sum;
    }

}

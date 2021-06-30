package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Ball_Pick {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        int[] ball = new int[M+1];

        for(int i=0;i<N;i++){
            int x = input.nextInt();
            ball[x] += 1;
        }

        int result = 0;

        for(int i = 1; i<=M;i++){
            N -= ball[i];
            result += N * ball[i];
        }
        
        System.out.println(result);

    }
}

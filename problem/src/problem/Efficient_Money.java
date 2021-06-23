package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Efficient_Money {


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[] number = new int[N];

        int min = 10000;

        for(int i=0;i<N;i++)
            number[i] = input.nextInt();

        int[] d= new int[M+1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for(int i=0;i<N;i++){
            for(int j =number[i];j<=M;j++){
                if(d[j-number[i]]!=10001)
                    d[j]=Math.min(d[j],d[j-number[i]]+1);
            }
        }

        if(d[M]==10001)
            System.out.println(-1);
        else
            System.out.println(d[M]);
    }
}

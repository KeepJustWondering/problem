package Dinamic;

import java.util.Scanner;

public class Int_Triangle {
    public static int[][] dp;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        dp = new int[N][N];
        int x = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j<=x)
                    dp[i][j]=input.nextInt();
            }
            x++;
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                int sum1, sum2;
                if(j==0)
                    sum1=0;
                else
                    sum1 = dp[i-1][j-1];

                sum2 = dp[i-1][j];

                dp[i][j]= dp[i][j] + Math.max(sum1,sum2);
            }
        }
        int max = 0;
        for(int i=0;i<N;i++){
            if(dp[N-1][i]>max)
                max = dp[N-1][i];
        }

        System.out.println( max);
    }
}

package Shortest;

import java.util.Arrays;
import java.util.Scanner;

public class Hide_Seek {
    public static final int INF = (int)1e9;
    public static int N,M;
    public static int[][] graph= new int[20000][20000];
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();

        for(int i=1;i<=N;i++)
            Arrays.fill(graph[i],INF);

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j)
                    graph[i][j]=0;
            }
        }

        for(int i=0;i<M;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            graph[a][b] =1;
            graph[b][a] =1;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++)
                    graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
            }
        }

        int index = 0;
        int max = 0;
        int count = 0;

        for(int j=1;j<=N;j++){
            if(graph[1][j]>max){
                count = 1;
                index = j;
                max = graph[1][j];
            }
            else if(graph[1][j]==max)
                count++;
        }

        System.out.println(index+" "+max+" "+count);


    }
}

package ShortestPath;

import java.util.Arrays;
import java.util.Scanner;


public class Future_City {
    public static final int INF = (int) 1e9;
    public static int[][] graph = new int[101][101];



    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();

        for(int i = 0;i<101;i++)//모든 그래프의 거리 무한으로 초기화
            Arrays.fill(graph[i],INF);

        for(int a= 1;a<=N;a++){//자신 까지의 거리 0
            for(int b= 1;b<=N;b++){
                if(a==b)
                   graph[a][b] = 0;
            }
        }

        for(int i=0;i<M;i++){//입력받은 도시들의 거리 1로
            int a = input.nextInt();
            int b = input.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for(int i=1;i<=N;i++){
            for(int a=1;a<=N;a++){
                for(int b=1;b<=N;b++)
                    graph[a][b] = Math.min(graph[a][b],graph[a][i]+graph[i][b]);
            }
        }


        int X = input.nextInt();
        int K = input.nextInt();


        if(graph[1][K]==INF || graph[K][X]== INF)
            System.out.println(-1);
        else
            System.out.println(graph[1][K]+graph[K][X]);

    }
}

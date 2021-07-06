package DorB_FS;

import java.util.Scanner;

public class Competive_Infection {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int N,K,S;
    public static int[][] map = new int[200][200];
    public static int[][] temp = new int[200][200];

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Competive_Infection result = new Competive_Infection();
        N = input.nextInt();
        K = input.nextInt();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                map[i][j] = input.nextInt();
                temp[i][j] = map[i][j];
            }
        }
        S = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();

        System.out.println(result.pos(x,y));

    }
    private void Insfection(int x){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==x){
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx==N||ny==N||nx==-1||ny==-1)
                            continue;
                        if(map[nx][ny]==0)
                            temp[nx][ny]=x;
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                map[i][j]=temp[i][j];
        }

    }

    private int pos(int x,int y){
        for(int i=0;i<S;i++){
            for(int j=1;j<=K;j++)
                Insfection(j);
        }
        return map[x-1][y-1];
    }
}

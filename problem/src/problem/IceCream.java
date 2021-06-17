package Search;
import java.util.Scanner;


public class IceCream {


    public static void main(String[] args){
        Scanner input =new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        input.nextLine();

        int[][] frame = new int[N][M];
        for(int i=0;i<N;i++){
            String s = input.nextLine();
            for(int j=0;j<M;j++){
                frame[i][j] = s.charAt(j)-'0';
            }
        }
        int count = 0;

        IceCream result = new IceCream();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(result.dfs(frame,i,j,N,M))
                    count++;
            }
        }

        System.out.println(count);
    }

    private boolean dfs(int[][] frame,int x,int y,int N,int M){
        if(x<0||x>=N||y<0||y>=M)
            return false;

        if(frame[x][y]==0){
            frame[x][y]=1;
            dfs(frame,x-1,y,N,M);
            dfs(frame,x,y-1,N,M);
            dfs(frame,x+1,y,N,M);
            dfs(frame,x,y+1,N,M);
            return true;
        }

        return false;
    }

}

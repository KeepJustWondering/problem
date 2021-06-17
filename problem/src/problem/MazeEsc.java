package Search;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
class Node{
    int x;
    int y;

    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class MazeEsc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        input.nextLine();

        int[][] frame = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = input.nextLine();
            for (int j = 0; j < M; j++) {
                frame[i][j] = s.charAt(j) - '0';
            }
        }
        MazeEsc result = new MazeEsc();
        System.out.println(result.BFS(N,M,0,0,frame));

    }

    private int BFS(int N,int M,int x,int y,int[][] frame){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        Queue<Node> process = new LinkedList();
        process.offer(new Node(x,y));

        while(!process.isEmpty()){
            Node node = process.poll();
            x = node.getX();
            y = node.getY();

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M)
                    continue;
                if(frame[nx][ny]==0)
                    continue;
                if(frame[nx][ny]==1){
                    frame[nx][ny]=frame[x][y]+1;
                    process.offer(new Node(nx,ny));
                }
            }
        }
        return frame[N-1][M-1];
    }


}

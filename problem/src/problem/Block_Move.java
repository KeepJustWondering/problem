package DorB_FS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Loc{
    private int x= 0;
    private int y= 0;
    public Loc(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
class Robot{
    private Loc front;
    private Loc back;
    private int count;
    public Robot(Loc front,Loc back,int count){
        this.back = back;
        this.front = front;
        this.count = count;
    }

    public Loc getBack() {
        return back;
    }

    public Loc getFront() {
        return front;
    }

    public int getCount() {
        return count;
    }
}
public class Block_Move {
    public static int[][] Board = { {0,0,0,1,1},
                                    {0,0,0,1,0},
                                    {0,1,0,1,1},
                                    {1,1,0,0,1},
                                    {0,0,0,0,0}};
    public static int N = Board.length;
    public static boolean[][] wall;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Block_Move result = new Block_Move();
        wall=new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(Board[i][j]==1)
                    wall[i][j]=true;
            }
        }

        result.moving();

        System.out.print(Board[N-1][N-1]-1);

    }
    private void moving(){
        
        Loc front = new Loc(0,0);
        Loc back = new Loc(0,1);
        Queue<Robot> q = new LinkedList<>();
        q.offer(new Robot(front,back,1));

        while(!q.isEmpty()){
            Robot robot = q.poll();
            //네 방향 이동
            for(int r=0;r<4;r++){
                int fx = robot.getFront().getX()+dx[r];
                int fy = robot.getFront().getY()+dy[r];
                int bx = robot.getBack().getX()+dx[r];
                int by = robot.getBack().getY()+dy[r];

                if(fx==-1||fx==N||fy==-1||fy==N||bx==-1||bx==N||by==-1||by==N)
                    continue;
                if(wall[fx][fy]||wall[bx][by]||(Board[fx][fy]!=0&&Board[bx][by]!=0))
                    continue;
                q.offer(new Robot(new Loc(fx,fy),new Loc(bx,by),robot.getCount()+1));
            }
            //front 축 기준 회전 4개
            for(int r=0;r<4;r++){
                int fx = robot.getFront().getX();
                int fy = robot.getFront().getY();
                int bx = robot.getFront().getX()+dx[r];
                int by = robot.getFront().getY()+dy[r];

                int rx = robot.getBack().getX()+bx-fx;
                int ry = robot.getBack().getY()+by-fy;

                if(fx==-1||fx==N||fy==-1||fy==N||bx==-1||bx==N||by==-1||by==N||rx==-1||rx==N||ry==-1||ry==N)
                    continue;
                if(wall[rx][ry]||(Board[fx][fy]!=0&&Board[bx][by]!=0))
                    continue;
                q.offer(new Robot(new Loc(fx,fy),new Loc(bx,by),robot.getCount()+1));
            }
            //back 축 기준 회전 4개
            for(int r=0;r<4;r++){
                int fx = robot.getBack().getX()+dx[r];
                int fy = robot.getBack().getY()+dy[r];
                int bx = robot.getBack().getX();
                int by = robot.getBack().getY();

                int rx = robot.getFront().getX()+fx-bx;
                int ry = robot.getFront().getY()+fy-by;

                if(fx==-1||fx==N||fy==-1||fy==N||bx==-1||bx==N||by==-1||by==N||rx==-1||rx==N||ry==-1||ry==N)
                    continue;
                if(wall[rx][ry]||(Board[fx][fy]!=0&&Board[bx][by]!=0))
                    continue;
                q.offer(new Robot(new Loc(fx,fy),new Loc(bx,by),robot.getCount()+1));
            }

            if(Board[robot.getFront().getX()][robot.getFront().getY()]>robot.getCount()||Board[robot.getFront().getX()][robot.getFront().getY()]==0)
                Board[robot.getFront().getX()][robot.getFront().getY()]=robot.getCount();
            if(Board[robot.getBack().getX()][robot.getBack().getY()]>robot.getCount()||Board[robot.getBack().getX()][robot.getBack().getY()]==0)
                Board[robot.getBack().getX()][robot.getBack().getY()]=robot.getCount();
        }

    }

}

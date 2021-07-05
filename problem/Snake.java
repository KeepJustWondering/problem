package Implemented;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    private int time;
    private char direction;
    public Node(int time, char direction){
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return time;
    }

    public char getDirection() {
        return direction;
    }
}

class position{
    private int x;
    private int y;
    public position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Snake {
    public static int n, k, l;
    public static int[][] arr = new int[101][101]; // 맵 정보
    public static ArrayList<Node> info = new ArrayList<>();
    public static int dx[] = {0, 1, 0, -1};
    public static int dy[] = {1, 0, -1, 0};

    public static int turn(int direction, char c){
        if(c=='L'){
            if(direction==0)
                direction = 3;
            else
                direction--;
        }
        else
            direction = (direction +1) %4;

        return direction;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        k = input.nextInt();

        for(int i=0; i<k; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            arr[a][b] = 1;
        }
        l = input.nextInt();
        for(int i= 0;i<l;i++){
            int x=  input.nextInt();
            char c= input.next().charAt(0);
            info.add(new Node(x,c));
        }
        System.out.println(simulate());

    }
    public static int simulate(){
        int x = 1, y =1;
        arr[x][y]= 2;
        int direction = 0;
        int time =0;
        int index = 0;

        Queue<position> q = new LinkedList<>();
        q.offer(new position(x,y));

        while(true){
            int nx = x +dx[direction];
            int ny = y +dy[direction];

            if(1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2){
                if(arr[nx][ny]==0){
                    arr[nx][ny]=2;
                    q.offer(new position(nx, ny));
                    position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new position(nx, ny));
                }
            }
            else {
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;
            if (index < l && time == info.get(index).getTime()) {
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }
}

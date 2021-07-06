package DorB_FS;

import java.util.ArrayList;
import java.util.Scanner;

class node{
    private int x;
    private int y;
    public node(int x, int y){
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

public class Find_City {
    public static int N,M,K,X;
    public static int[] parent = new int[300001];
    public static int[] count = new int[300001];
    public static ArrayList<node> a = new ArrayList<>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        K = input.nextInt();
        X = input.nextInt();

        for(int i=1;i<=N;i++)
            parent[i]=i;

        for(int i=0;i<M;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            a.add(new node(x,y));
        }

        Find_City result = new Find_City();

       result.solution();
    }

    private void solution(){
        for(int i=0;i<a.size();i++){
            int x= a.get(i).getX();
            int y= a.get(i).getY();
            if(parent[y]==y||parent[y]>x)
                parent[y]=x;
        }

        for(int i=2;i<=N;i++){
            int counts =1;
            while(parent[i]!=1){
                if(parent[i]==i)
                    break;
                counts ++;
                parent[i]=parent[parent[i]];
            }
            count[i]=counts;
        }
        boolean s = false;

        for(int i=1;i<=N;i++){
            if(count[i] == K) {
                s = true;
                System.out.println(i);
            }
        }
        if(s== false)
            System.out.println(-1);
    }
}

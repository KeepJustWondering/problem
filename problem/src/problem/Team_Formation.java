package Graph;

import java.util.ArrayList;
import java.util.Scanner;

class Node{
    private int a;
    private int b;

    public Node(int a,int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class Team_Formation {
    public static int N,M;

    public static int[] parent = new int[100001];

    public static void union(int a, int b){
        a=findParent(a);
        b=findParent(b);
        if(a>b)
            parent[a]=b;
        else
            parent[b]=a;
    }

    public static int findParent(int x){
        if(x==parent[x])
            return x;

        return parent[x]=findParent(parent[x]);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Node> list =  new ArrayList<>();
        N = input.nextInt();
        M = input.nextInt();

        for(int i=1;i<=N;i++)
            parent[i]=i;

        for(int i=0;i<M;i++){
            int v =input.nextInt();
            int a =input.nextInt();
            int b =input.nextInt();

            if(v==0)
                union(a,b);

            else{
                Node node = new Node(a,b);
                list.add(node);
            }
        }
        for(int i=0;i<list.size();i++){
            int a = list.get(i).getA();
            int b = list.get(i).getB();
            if(parent[a]==parent[b])
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}

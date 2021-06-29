package Graph;

import java.util.*;

class Point implements Comparable<Point>{
    private int distance;
    private int a;
    private int b;

    public Point(int distance,int a,int b){
        this.distance = distance;
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getDistance() {
        return distance;
    }
    @Override
    public int compareTo(Point Other){
        if(this.distance < Other.distance)
            return -1;
        return 1;
    }
}

public class City_Division {
    public static int N,M;
    public static int[] parent = new int[100001];
    public static ArrayList<Point> graph = new ArrayList<>();

    public static int findParent(int x){
        if(x==parent[x])
            return x;

        return parent[x]=findParent(parent[x]);
    }

    public static void union(int a, int b){
        a=findParent(a);
        b=findParent(b);
        if(a>b)
            parent[a]=b;
        else
            parent[b]=a;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();

        for(int i=1;i<=N;i++)
            parent[i] = i;

        for(int i=0;i<M;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int dis = input.nextInt();

            graph.add(new Point(dis, a, b));
        }
        Collections.sort(graph);
        int result = 0;
        int max = 0;
        for(int i=0;i<graph.size();i++){
            int a = graph.get(i).getA();
            int b = graph.get(i).getB();
            int dis = graph.get(i).getDistance();

            if(findParent(a)!=findParent(b)){
                union(a,b);
                result +=dis;
                max = dis;
            }
        }

        System.out.println(result-max);
    }
}


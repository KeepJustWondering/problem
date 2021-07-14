package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Dark_Road {
    public static int N,M;
    public static int[] parent = new int[200001];
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Dark_Road solution = new Dark_Road();
        N = input.nextInt();
        M = input.nextInt();

        for(int i=1;i<=N;i++)
            parent[i]=i;

        for(int i=0;i<M;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int dist = input.nextInt();
            edges.add(new Edge(dist,a,b));
        }
        Collections.sort(edges);

        int result = 0;
        int all = 0;
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            int dist = edges.get(i).getDistance();
            all += dist;
            if(solution.FindParent(a)!=solution.FindParent(b)){
                solution.Union(a,b);
                result += dist;
            }
        }

        System.out.println(all-result);
    }


    private int FindParent(int a){
        if(parent[a]==a)
            return a;

        return parent[a]=FindParent(parent[a]);
    }

    private void Union(int a, int b){
        a = FindParent(a);
        b = FindParent(b);

        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }
}

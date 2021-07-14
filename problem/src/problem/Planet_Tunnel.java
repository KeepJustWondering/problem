package Graph;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Spot{
    private int index;
    private int x;
    private int y;
    private int z;
    public Spot(int index,int x, int y, int z ){
        this.x = x;
        this.y = y;
        this.z = z;
        this.index =index;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getIndex() {
        return index;
    }
}
class Line implements Comparable<Line>{
    private Spot a;
    private Spot b;
    private int dist;

    public Line(Spot a, Spot b){
        this.a = a;
        this.b = b;
        this.dist = countDist(a,b);
    }

    private int countDist(Spot a, Spot b){
        return Math.min(Math.abs(a.getX()-b.getX()),Math.min(Math.abs(a.getY()-b.getY()),Math.abs(a.getZ()-b.getZ())));
    }

    public Spot getA() {
        return a;
    }

    public Spot getB() {
        return b;
    }

    public int getDist() {
        return dist;
    }
    public int compareTo(Line other){
        if(this.dist < other.dist)
            return -1;
        return 1;
    }
}

public class Planet_Tunnel {
    public static int[] parent = new int[100001];
    public static int N;
    public static ArrayList<Spot> spot = new ArrayList<>();
    public static ArrayList<Line> line = new ArrayList<>();

    public static void main(String[] args){
        Planet_Tunnel solution = new Planet_Tunnel();
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        for(int i=1;i<=N;i++)
                parent[i]=i;


        for(int i=1;i<=N;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();

            spot.add(new Spot(i,x,y,z));

        }

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++)
                line.add(new Line(spot.get(i),spot.get(j)));
        }

        Collections.sort(line);

        int result = 0;
        for(int i=0;i<line.size();i++){
            Spot a= line.get(i).getA();
            Spot b= line.get(i).getB();
            int dis = line.get(i).getDist();
            int x = a.getIndex();
            int y = b.getIndex();
            if(solution.FindParent(x)!=solution.FindParent(y)){
                solution.Union(x,y);
                result += dis;
            }
        }
        System.out.println(result);

    }

    private int FindParent(int x){
        if(parent[x]==x)
            return x;
        return parent[x]=FindParent(parent[x]);
    }

    private void Union(int a, int b){
        a = FindParent(a);
        b = FindParent(b);
        if(a>b)
            parent[a]=b;
        else
            parent[b]=a;
    }
}

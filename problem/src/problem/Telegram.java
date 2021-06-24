package ShortestPath;


import java.util.*;

class Node implements Comparable<Node>{
    private int city;
    private int time;

    public Node(int city,int time){
        this.city = city;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public int getCity() {
        return city;
    }
    @Override
    public int compareTo(Node other){
        if(this.time < other.time)
            return -1;
        return 1;
    }
}


public class Telegram {
    public static final int INF = (int) 1e9;
    public static int N,M,start;


    public static int[] t = new int[30001];//최단시간 테이블
    public static ArrayList<ArrayList<Node>> graph= new ArrayList<ArrayList<Node>>();// 연결정보

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));
        t[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int time = node.getTime();
            int now = node.getCity();

            if(t[now]<time) continue;

            for(int i=0;i< graph.get(now).size();i++){
                int cost = t[now] + graph.get(now).get(i).getTime();

                if(cost < t[graph.get(now).get(i).getCity()]) {
                    t[graph.get(now).get(i).getCity()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getCity(),cost));
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner input =new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        start = input.nextInt();

        for(int i=0;i<=N;i++) // 그래프 초기화
            graph.add(new ArrayList<Node>());
        
        for(int i=0;i<M;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            graph.get(a).add(new Node(b,c));
        }

        Arrays.fill(t,INF); // 최단시간 배열 무한으로 초기화

        dijkstra(start);

        int max =0;
        int count = 0;
        for(int i=1;i<=N;i++){
            if(t[i]!=INF)
                count++;
                max = Math.max(max,t[i]);
        }

        System.out.println(count-1+" "+max);


    }

}

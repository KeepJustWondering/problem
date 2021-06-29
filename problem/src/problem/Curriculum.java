package Graph;

import java.util.*;


public class Curriculum {

    public static int N;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] times =new int[501];
    public static int[] indegree =new int[501];


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        for(int i=0;i<=N;i++)
            graph.add(new ArrayList<>());

        for(int i=1;i<=N;i++){
            int t = input.nextInt();
            int x = input.nextInt();
            while(x!= -1){
                graph.get(x).add(i);
                indegree[i] += 1;
                x = input.nextInt();
            }
            times[i] = t;
        }

        topologySort();
    }

    private static void topologySort() {
       int[] result = times.clone();
       Queue<Integer> q = new LinkedList<>();

       for(int i=1;i<=N;i++){
           if(indegree[i] ==0 )
               q.offer(i);
       }

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;

                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

       for(int i=1;i<=N;i++)
           System.out.println(result[i]);

    }
}

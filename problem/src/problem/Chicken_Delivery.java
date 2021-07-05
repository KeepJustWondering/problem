package Implemented;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Min implements Comparable<Min>{
    private int x;
    private int y;
    private int sum;

    public Min(int x,int y,int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSum() {
        return sum;
    }

    public int compareTo(Min other){
        if(this.sum < other.sum)
            return -1;
        return 1;
    }


}


public class Chicken_Delivery {
    public int N = 5;
    public int M = 1;
    public static ArrayList<Min> min = new ArrayList<>();
    public static int[][] map={{1,2,0,0,0},
            {1,2,0,0,0},
            {1,2,0,0,0},
            {1,2,0,0,0},
            {1,2,0,0,0}};


    public static void main(String[] args){
        Chicken_Delivery result = new Chicken_Delivery();
        result.MinSort();
        result.count();

    }
    private void MinSort(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

                if(map[i][j]==2){
                    int sum = 0;
                    for(int x=0;x<N;x++){
                        for(int y=0;y<N;y++){
                            if(map[x][y]==1){
                                sum += Math.abs(i-x)+Math.abs(j-y);
                            }
                        }
                    }
                    min.add(new Min(i,j,sum));
                }

            }
        }
        Collections.sort(min);
    }

    private void count(){
        int sum =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){


                int MD = 1000;
                for(int s=0;s<M;s++){
                    Min chicken = min.get(s);
                    if(map[i][j]==1){
                        int distance = Math.abs(i-chicken.getX())+Math.abs(j-chicken.getY());
                        if(MD>distance)
                            MD = distance;
                    }
                }
                if(MD!=1000)
                    sum += MD;
                
            }
        }
        System.out.println(sum);
    }


}

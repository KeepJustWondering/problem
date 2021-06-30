package test;

import java.util.LinkedList;
import java.util.Queue;

class food{
    int num;
    int time;

    public food(int num, int time){
        this.num = num;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public int getNum() {
        return num;
    }

    public void count(){
        this.time--;
    }
}

public class Eating_Live {
    public static int[] food_times = {3,1,2};
    public static int k = 5;

    public static void main(String[] args){
        Eating_Live RESULT = new Eating_Live();
        System.out.println(RESULT.solution());
    }

    private int solution(){
        Queue<food> q = new LinkedList<>();
        for(int i=0;i<food_times.length;i++)
            q.offer(new food(i+1,food_times[i]));

        for(int i=0;i<k;i++){
            food a = q.poll();
            if(a.getTime()==0)
                a = q.poll();

            a.count();
            q.offer(a);
        }

        return q.poll().getNum();
    }


}
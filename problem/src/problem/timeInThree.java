package Implemented;

import java.util.Scanner;


public class timeInThree {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        timeInThree result = new timeInThree();
        System.out.println(result.TimeCount(N));

    }

    private int TimeCount(int N){
        int hour = 0;
        int minute = 0;
        int second = 0;
        int count = 0;

        while(hour != N+1){
            second++;

            if(second==60){
                second=0;
                minute++;
            }
            if(minute==60){
                minute=0;
                hour++;
            }

            if(judge(hour,minute,second)==true)
                count++;

        }


        return count;
    }
    private boolean judge(int h,int m,int s){
        String H =Integer.toString(h)+Integer.toString(m)+Integer.toString(s);
        String[] time = H.split("");
        for(int i=0;i<time.length;i++){
            if(time[i].equals("3"))
                return true;
        }
        return false;
    }
}

package Dinamic;

import java.util.Scanner;

class task{
    private int day;
    private int price;
    public task(int day, int price){
        this.day = day;
        this.price = price;
    }

    public int getDay() {
        return day;
    }

    public int getPrice() {
        return price;
    }
}

public class Leave {
    public static int N;
    private static task[] dp;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        dp = new task[N+1];

        for(int i=0;i<N;i++){
            int day = input.nextInt();
            int price = input.nextInt();
            dp[i] = new task(day,price);
        }
        dp[N]= new task(0,0);

        for(int i=1;i<N+1;i++){
            task a = dp[i];

            int MaxPrice = 0;
            int day = 0;

            for(int j=0;j<i;j++){
                if(dp[j].getDay()<=i){
                    if(MaxPrice<dp[j].getPrice()){
                        MaxPrice = dp[j].getPrice();
                        day = dp[j].getDay();
                    }
                }
            }
            dp[i]= new task(a.getDay()+day,a.getPrice()+MaxPrice);
        }

        System.out.println(dp[N].getPrice());
    }
}

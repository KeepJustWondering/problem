package Greedy;

public class changeMoney {

    public static void main(String[] args){

        int n = 1260;
        int[] coin_types = {500,100,50,10};

        changeMoney result = new changeMoney();
        System.out.println(result.Money(n,coin_types));

    }
    private int Money(int n,int[] ct){
        int count =0;
        int index = 0;

        while(n>0){
            count += n/ct[index];
            n %= ct[index++];
        }

        return count;
    }

}

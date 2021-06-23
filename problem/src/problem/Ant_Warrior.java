package DynamicProgramming;

import java.util.Scanner;

public class Ant_Warrior {

    public  static int[] d = new int[100];

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] number = new int[N];
        for(int i = 0;i<N;i++)
            number[i]=input.nextInt();

        d[0]= number[0];
        d[1]= number[1];

        for(int i=2;i<N;i++){
            d[i]=number[i];

            d[i]=Math.max(d[i]+d[i-2],d[i-1]);
        }

        System.out.println(d[N-1]);
    }
}

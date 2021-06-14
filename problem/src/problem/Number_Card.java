package Greedy;

import java.util.Scanner;

public class Number_Card {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();

        int[][] card = new int[row][col];

        for(int i = 0; i< row;i++){
            for(int j=0;j< col;j++){
                card[i][j]=input.nextInt();
            }
        }

        Number_Card result = new Number_Card();

        int[] min = new int[row];

        for(int i = 0; i< row;i++){
            min[i] = result.min(card[i]);
        }

        System.out.println(result.max(min));

    }
    private int min(int[] raw){
        int min =10000;
        for(int i=0;i<raw.length;i++){
            if(raw[i]<min)
                min = raw[i];
        }

        return min;
    }
    private int max(int[] min){
        int max =1;
        for(int i=0;i<min.length;i++){
            if(min[i]>max)
                max = min[i];
        }

        return max;
    }
}

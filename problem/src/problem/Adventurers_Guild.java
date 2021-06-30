package test;

import java.util.Arrays;
import java.util.Scanner;

public class Adventurers_Guild {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];

        for(int i=0;i<n;i++)
            array[i] = input.nextInt();

        Arrays.sort(array);

        int count = 0;
        int x = 0;
        for(int i = n-1;i>=0;i--){
            if(x==0){
                x= array[i];
                count++;
            }
            x--;
        }
        System.out.println(count);

    }
}

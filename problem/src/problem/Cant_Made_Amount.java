package test;

import java.util.Arrays;
import java.util.Scanner;

public class Cant_Made_Amount {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] array = new int[n];

        for(int i=0;i<n;i++)
            array[i] = input.nextInt();

        Arrays.sort(array);

        int result = 1;

        for(int i=0;i<n;i++){
            if(result<array[i])
                break;

            result += array[i];
        }

        System.out.println(result);
    }

}

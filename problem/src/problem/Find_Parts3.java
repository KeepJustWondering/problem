package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Find_Parts3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Find_Parts3 result = new Find_Parts3();
        HashSet<Integer> part = new HashSet<>();


        int p = input.nextInt();
        for(int i=0;i<p;i++){
            int x = input.nextInt();
            part.add(x);
        }

        int n = input.nextInt();
        int[] need = new int[n];
        for(int i=0;i<n;i++)
            need[i]=input.nextInt();

        for(int i=0;i<n;i++){
            if(part.contains(need[i]))
                System.out.print("yes ");
            else
                System.out.print("no ");
        }


    }
}

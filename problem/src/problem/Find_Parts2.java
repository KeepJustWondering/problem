package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Find_Parts2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Find_Parts2 result = new Find_Parts2();

        int p = input.nextInt();
        int[] part = new int[p];
        for(int i=0;i<p;i++)
            part[i]=input.nextInt();

        Arrays.sort(part);

        int n = input.nextInt();
        int[] need = new int[n];
        for(int i=0;i<n;i++)
            need[i]=input.nextInt();

        int[] array = result.newArray(part);

        for(int i=0;i<n;i++){
            if(array[need[i]]>0)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }
    }
    private int[] newArray(int[] part){
        int[] newArray = new int[part[part.length-1]+1];
        for(int i=0;i<newArray.length;i++){
            for(int j=0;j<part.length;j++){
                if(i==part[j])
                    newArray[i]++;
            }
        }
        return newArray;
    }
}

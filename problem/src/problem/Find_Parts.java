package BinarySearch;

import DataStructure.Factorial;

import java.util.Arrays;
import java.util.Scanner;

public class Find_Parts {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Find_Parts result = new Find_Parts();

        int p = input.nextInt();
        int[] part = new int[p];
        for(int i=0;i<p;i++)
            part[i]=input.nextInt();

        Arrays.sort(part);

        int n = input.nextInt();
        int[] need = new int[n];
        for(int i=0;i<n;i++)
            need[i]=input.nextInt();

        for(int i=0;i<n;i++){
            if(result.search(part,0,p-1,need[i])!=-1)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }

    }
    private int search(int[] part,int first,int last, int need){
        if(first>last)
            return -1;
        int mid = (first+last)/2;

        if(part[mid] == need )
            return mid;
        else if(part[mid] < need)
            return search(part,mid+1,last,need);
        else
            return search(part,first,mid-1,need);
    }
}

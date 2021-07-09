package BinarySearch;

import java.util.Scanner;

public class Find_FP {
    public static int N;
    public static int[] list;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Find_FP result = new Find_FP();
        N = input.nextInt();
        list = new int[N];
        for(int i=0;i<N;i++)
            list[i]=input.nextInt();

        System.out.println(result.search(0,N-1));

    }
    private int search(int first, int last){
        int mid = (first+last)/2;

        if(list[first]==first)
            return first;
        if(list[last]==last)
            return last;
        if(list[mid]==mid)
            return mid;
        if(first==last||first-last==1)
            return -1;

        if(list[mid]>mid)
            return search(first,mid-1);
        else
            return search(mid+1,last);
    }
}

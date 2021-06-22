package BinarySearch;

import java.util.Scanner;

public class Split_Half {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        Split_Half result = new Split_Half();
        int N = input.nextInt();
        int n = input.nextInt();
        int[] number = new int[N];
        for(int i=0;i<N;i++)
            number[i] = input.nextInt();

        int index = result.search(number,0,N-1,n);

        if(index == -1)
            System.out.println("찾을 수 없음");
        else
            System.out.println(index+1);
    }

    private int search(int[] number, int first, int last, int n){
        if(first > last)
            return -1;

        int mid =  (first+last)/2;

        if(number[mid]==n)
            return mid;


        if(number[mid]<n)
            return search(number,mid+1,last,n);

        else
            return search(number,first,mid-1,n);

    }
}

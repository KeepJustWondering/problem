package BinarySearch;

import java.util.Scanner;

public class Specific_Number {
    public static int N;
    public static int value;
    public static int[] list;
    public static int count =0;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Specific_Number solution = new Specific_Number();
        N = input.nextInt();
        list = new int[N];
        value = input.nextInt();
        for(int i=0;i<N;i++)
            list[i]=input.nextInt();

        int index = solution.search(0,N-1);

        if(index != -1){
            solution.up(index);
            solution.down(index);
            System.out.println(count-1);
        }
        else
            System.out.println(index);

    }

    private int search(int first, int last){
        if(value<list[first]||value>list[last])
            return -1;
        int mid = (first+last)/2;
        if(list[first]==value)
            return first;
        if(list[last]==value)
            return last;
        if(list[mid]==value)
            return mid;

        if(first == mid || last == mid)
            return -1;

        if(list[mid]>value)
            return search(first,mid-1);
        else
            return search(mid+1,last);
    }

    private int up(int index){
        for(int i=index;i<N;i++){
            if(list[i]==value)
                count++;
            else
                return count;
        }
        return count;
    }
    private int down(int index){
        for(int i=index;i>=0;i--){
            if(list[i]==value)
                count++;
            else
                return count;
        }
        return count;
    }
}

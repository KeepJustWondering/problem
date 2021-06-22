package BinarySearch;

import java.util.Scanner;

public class Tteokbokki {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Tteokbokki result = new Tteokbokki();

        int N = input.nextInt();
        int[] rc = new int[N];

        int size = input.nextInt();

        for(int i=0;i<N;i++)
            rc[i] = input.nextInt();

        int max = rc[0];

        for(int i=0;i<N;i++){
            if(max<rc[i])
                max = rc[i];
        }
        result.search(rc,0,max,size);
    }
    private void search(int[] rc,int start,int end,int size){
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            total = sum(rc,size,mid);

            if (total < size) {
                end = mid - 1;
            }
            else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }

    private int sum(int[] rc, int size, int num) {
        int sum = 0;
        for (int i = 0; i < rc.length; i++) {
            if (rc[i] - num > 0)
                sum += rc[i] - num;
        }
        return sum;
    }

}

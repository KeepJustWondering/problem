package Sort;

import java.util.Scanner;

public class Card_Sort {
    public static int N;
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
        N = input.nextInt();
        int[] count = new int[N-1];
        int[] card = new int[N];

        for(int i=0;i<N;i++)
            card[i] = input.nextInt();
        int sum = card[0];

        for(int i=1;i<N;i++){
            sum+=card[i];
            count[i-1] = sum;
        }
        sum = 0;
        for(int i=0;i<N-1;i++)
            sum += count[i];

        System.out.println(sum);
    }
}

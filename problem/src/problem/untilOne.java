package Greedy;
import java.util.Scanner;

public class untilOne {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        untilOne result = new untilOne();
        System.out.println(result.account(N,K));
    }

    private int account(int N, int K){
        int count =0;

        while(N!=1){
            if(N%K==0)
                N /= K;
            else
                N--;

            count++;
        }

        return count;
    }
}

package Greedy;
import java.util.Scanner;
import java.util.Arrays;

public class LawOfLargeNumbers {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int K = input.nextInt();

        int[] num = new int[N];
        for(int i=0 ; i<N ; i++){
            num[i]= input.nextInt();
        }
        LawOfLargeNumbers result = new LawOfLargeNumbers();
        Arrays.sort(num);
        System.out.println(result.Large(num,M,K));
    }

    private int Large(int[] num,int M,int K){
        int One = num[num.length-1];
        int Two = num[num.length-2];
        int goal = M/(K+1);
        int Remaine = M%(K+1);

        return (One*goal*K)+(Two*goal)+(One*Remaine);
    }


}

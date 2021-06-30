package test;

import java.util.Scanner;

public class Mul_or_Add {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String STR = input.next();
        String[] str = STR.split("");
        int[] num = new int[str.length];

        for(int i=0;i<num.length;i++)
            num[i] = Integer.parseInt(str[i]);

        int result = num[0];

        for(int i=1;i<num.length;i++){
            if(result==0||result==1||num[i]==1||num[i]==0)
                result += num[i];
            else
                result *= num[i];
        }
        
        System.out.println(result);

    }
}

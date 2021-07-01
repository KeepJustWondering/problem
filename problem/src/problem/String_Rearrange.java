package Implemented;

import java.util.Arrays;
import java.util.Scanner;

public class String_Rearrange {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String S = input.next();
        String[] str = S.split("");
        Arrays.sort(str);
        S = "";

        for(int i=0;i<str.length;i++)
            S += str[i];

        String s ="";
        int sum = 0;

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)>='0' && S.charAt(i)<='9')
                sum += S.charAt(i)-'0';
            else
                s += S.charAt(i);
        }
        s += sum;

        System.out.println(s);
    }
}

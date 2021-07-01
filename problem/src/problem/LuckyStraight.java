package Implemented;


import java.util.Scanner;

public class LuckyStraight {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length()/2;i++)
            left += s.charAt(i)-'0';

        for(int i=s.length()/2;i<s.length();i++)
            right += s.charAt(i)-'0';

        if(left==right)
            System.out.println("LUCKY");
        else
            System.out.println("READY");


    }
}

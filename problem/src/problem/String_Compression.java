package Implemented;

import java.util.Scanner;

public class String_Compression {

    public static String S;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String_Compression solution = new String_Compression();

        S = input.next();

        int i = 1;
        int min = 1000;
        while(i<=S.length()/2)
            min = Math.min(min,solution.change(i++));

        System.out.println(min);

    }

    private int change(int n){
        String prior = "";
        String pre = "";
        int sum = 1;
        String s = "";

        for(int i=0;i<n;i++)
            prior += S.charAt(i);

        for(int i=n;i+n<=S.length();i+=n){
            pre = "";
            for(int j=i;j<i+n;j++)// 현재를 구함
                pre += S.charAt(j);

            if(prior.equals(pre))
                sum++;
            else{
                s += sum+prior;
                prior = pre;
                sum=1;
            }
        }
        s += sum+prior;

        String[] a = s.split("1");
        s ="";
        for(int i=0;i<a.length;i++)
            s+=a[i];

        System.out.println(s+" "+ S.length()%n);
        int result=s.length()+S.length()%n;

        return result;
    }
}

package test;

import java.util.Scanner;

public class Flip_String {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String STR = input.next();
        String[] str = STR.split("");
        int one = 0 ;
        int zero = 0;

        String prior = str[0];
        for(int i=1;i<str.length;i++){
            if(!prior.equals(str[i])){
                if(prior.equals("1"))
                    one++;
                else
                    zero++;

                prior = str[i];
            }
        }

        if(prior.equals("1"))
            one++;
        else
            zero++;


        System.out.println(Math.min(one,zero));
    }
}

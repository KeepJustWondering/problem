package Implemented;
import java.util.Scanner;

public class UDLR {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        UDLR result = new UDLR();

        int[] loc= {1,1};

        int N = input.nextInt();
        input.nextLine();

        String S = input.nextLine();

        String[] s = S.split(" ");

        int i=0;
        while(i<s.length){
            loc = result.location(loc,s[i],N);
            i++;
        }

        System.out.println(loc[0]+" "+loc[1]);

    }

    private int[] location(int[] loc,String s, int N){
        switch(s){
            case "U":
                loc[0]--;
            case "D":
                loc[0]++;
            case "L":
                 loc[1]--;
            case "R":
                 loc[1]++;
        }
        if(loc[0]==0)
            loc[0]=1;
        if(loc[0]==N+1)
            loc[0]=N;
        if(loc[1]==0)
            loc[1]=1;
        if(loc[1]==N+1)
            loc[1]=N;

        return loc;
    }
}

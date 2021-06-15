package Implemented;

import java.util.Scanner;

public class royal_Night {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        String[] col = {"","a","b","c","d","e","f","g","h"};

        String L = input.next();
        String[] s = L.split("");
        int[] Loc=new int[2];

        for(int i=0;i<col.length;i++){
            if(s[0].equals(col[i]))
                Loc[0] = i;
        }
        int num = Integer.parseInt(s[1]);
        Loc[1]=num;

        royal_Night result = new royal_Night();

        System.out.println(result.count(Loc));

    }

    private int count(int[] Loc){
        int[][] move = {{-2,-1},{-1,-2},{2,-1},{1,-2},{-2,1},{-1,2},{2,1},{1,2}};
        int count = 0;

        for(int i=0;i<move.length;i++){
            int[] loc =Loc.clone();

            loc[0] += move[i][0];
            loc[1] += move[i][1];
            if(edge(loc)==true)
                count++;
        }
        return count;
    }
    private boolean edge(int[] loc){
        if(loc[0]<1||loc[1]<1||loc[1]>8||loc[0]>8)
            return false;

        return true;
    }
}

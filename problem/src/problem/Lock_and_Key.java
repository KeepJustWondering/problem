package Implemented;

import javax.swing.*;
import java.util.Scanner;

public class Lock_and_Key {
    public static int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
    public static int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};


    public static void main(String[] args){
        Lock_and_Key result = new Lock_and_Key();
        System.out.println(result.solution());
    }

    private int[][] rotations90(int[][] array){
        int x = array.length;
        int y = array[0].length;
        int[][] result = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j< y;j++)
                result[i][j] = array[x-j-1][i];
        }
        return result;
    }

    private boolean check(int[][] newLock){
        int length = newLock.length/3;
        for(int i=length;i<length*2;i++){
            for(int j=length;j<length*2;j++){
                if(newLock[i][j]!=1)
                    return false;
            }
        }
        return true;
    }

    private boolean solution(){
        int l = lock.length;
        int k = key.length;

        int[][] newLock = new int[l*3][l*3];

        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++)
                newLock[i+l][j+l]=lock[i][j];
        }

        for(int r=0;r<4;r++){
            key = rotations90(key);
            for(int x=0;x<l*2;x++){
                for(int y=0;y<l*2;y++){

                    for(int i=0;i<k;i++){
                        for(int j=0;j<k;j++)
                            newLock[x+i][y+j] += key[i][j];
                    }
                    if(check(newLock))
                        return true;

                    for(int i=0;i<k;i++){
                        for(int j=0;j<k;j++)
                            newLock[x+i][y+j] -= key[i][j];
                    }
                }
            }
        }
        return false;
    }

}

package Implemented;

import java.util.ArrayList;
import java.util.Collections;

class pos implements Comparable<pos>{
    private int x;
    private int y;
    private int Pob;//0 = p or 1 = b

    public pos(int x,int y, int Pob){
        this.x = x;
        this.y = y;
        this.Pob = Pob;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getPob() {
        return Pob;
    }

    @Override
    public int compareTo(pos other) {
        if(this.x < other.getX())
            return -1;
        return 1;
    }
    @Override
    public boolean equals(Object other){

            if (this.getX() == ((pos) other).getX() && this.getY() == ((pos) other).getY() && this.getPob() == ((pos) other).getPob())
                return true;

        return false;
    }
}

public class Pillar_and_beam {
    public static ArrayList<pos> struct = new ArrayList<>();
    public static int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},
            {1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},
            {1,1,1,0},{2,2,0,1}};
    
    public static void main(String[] args){
        Pillar_and_beam result = new Pillar_and_beam();
        result.solution();
        result.print();
    }

    private void solution(){
        for(int i=0;i<build_frame.length;i++){
            pos a = new pos(build_frame[i][0],build_frame[i][1],build_frame[i][2]);
            if(build_frame[i][3]==1){
                if(judge(a))
                    struct.add(a);
            }

            else{
                struct.remove(a);
                int index = 0;
                while(index < struct.size()){
                    if(!judge(struct.get(index))){
                        struct.add(a);
                        break;
                    }
                    index++;
                }
            }
        }
    }

    private void print(){
        Collections.sort(struct);

        int x=struct.size()-1;

        System.out.print("[");
        for(int i=0;i<x;i++){
            pos now = struct.get(i);
            System.out.print("["+now.getX()+", "+now.getY()+", "+ now.getPob()+"], ");
        }
        pos now = struct.remove(x);
        System.out.print("["+now.getX()+", "+now.getY()+", "+ now.getPob()+"]]");
    }
    //조건
    public static boolean judge(pos a){
        int x = a.getX();
        int y = a.getY();
        int p = a.getPob();

        if(p==0){// 기둥의 조건
            if(y==0||struct.contains(new pos(x,y,1))||struct.contains(new pos(x-1,y,1))||struct.contains(new pos(x,y-1,0)))
                return true;
        }

        else{// 보의 조건
            if(struct.contains(new pos(x+1,y-1,0))||struct.contains(new pos(x,y-1,0))||(struct.contains(new pos(x-1,y,1))&&struct.contains(new pos(x+1,y,1))))
                return true;
        }

        return false;
    }
}

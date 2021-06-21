package Sort;

import java.util.*;

class info implements Comparable<info>{
    private int score;
    private String name;

    public info(String name, int score){
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(info other){
        if(this.score < other.score)
                return -1;

        return 1;
    }

}

public class LowScore {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        List<info> std = new ArrayList<>();

        for(int i=0;i<N;i++){
            String name = input.next();
            int score= input.nextInt();

            std.add(new info(name,score));
        }
        Collections.sort(std);

        for(int i=0;i<N;i++)
            System.out.print(std.get(i).getName()+ " ");
    }
}

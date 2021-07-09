package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Node implements Comparable<Node> {
    int index;
    double fail;
    public Node(int index, double fail){
        this.fail = fail;
        this. index = index;
    }
    public double getFail() {
        return fail;
    }
    public int getIndex() {
        return index;
    }
    @Override
    public int compareTo(Node Other){
        if(this.fail <Other.getFail())
            return 1;
        else if(this.fail == Other.getFail())
            return Integer.compare(this.index, Other.getIndex());
        return -1;
    }
}

public class Failure_Rate {
    public static int N = 4;
    public static ArrayList<Node> a = new ArrayList<>();
    public static int[] stages = {4,4,4,4,4};

    public static void main(String[] args){
        Arrays.sort(stages);

        for(int i=1;i<N+1;i++){
            double count = 0;
            double layer = 0;
            for(int j=0;j<stages.length;j++){
                if(i == stages[j])
                    count++;
                if(i <= stages[j])
                    layer++;
            }
            a.add(new Node(i,count/layer));
        }

        Collections.sort(a);
        for(Node i:a)
            System.out.print(i.getIndex()+" ");

    }


}

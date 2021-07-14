package Graph;

import BinarySearch.Find_FP;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.ArrayList;
import java.util.Scanner;

public class Travel_Plan {
    public static int N,M;
    public static int[] parent = new int[501];

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Travel_Plan solution = new Travel_Plan();
        N = input.nextInt();
        M = input.nextInt();

        for(int i=1;i<=N;i++)
            parent[i]=i;

        for(int i=0;i<N;i++){
            for(int j = 0 ;j<N;j++){
                int x = input.nextInt();
                if(x==1)
                    solution.Union(i+1,j+1);
            }
        }
        int first = input.nextInt();

        for(int i=1;i<M;i++){
            int index = input.nextInt();

            if(parent[first]!=parent[index]) {
                first = -1;
                break;
            }
        }

        if(first == -1)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    private int FindParent(int a){
        if(parent[a]==a)
            return a;

        return parent[a]=FindParent(parent[a]);
    }

    private void Union(int a, int b){
        a = FindParent(a);
        b = FindParent(b);

        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }

}

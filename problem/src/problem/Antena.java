package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Antena {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        ArrayList a = new ArrayList();

        for(int i=0;i<N;i++){
            int x = input.nextInt();
            a.add(x);
        }
        Collections.sort(a);

        System.out.println(a.get((N-1)/2));
    }
}

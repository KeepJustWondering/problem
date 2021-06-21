package Sort;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class TopDown {
    public static void main(String[] args){
        TopDown result = new TopDown();
        Scanner input = new Scanner (System.in);

        int n = input.nextInt();
        Integer[] num = new Integer[n];

        for(int i=0;i<n;i++)
            num[i] = input.nextInt();

        Arrays.sort(num, Collections.reverseOrder());
        result.print(num);

    }

    private void print(Integer[] num){
        for(int i=0;i<num.length;i++)
            System.out.print(num[i]+" ");

    }

}

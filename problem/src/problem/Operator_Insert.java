package DorB_FS;

import java.util.ArrayList;
import java.util.Scanner;

public class Operator_Insert {
    public static int N;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int add, sub, mul, div;

    public static int max = (int) -1e9;
    public static int min = (int) 1e9;


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Operator_Insert result = new Operator_Insert();
        N = input.nextInt();
        for(int i=0;i<N;i++){
            int n  = input.nextInt();
            arr.add(n);
        }
        add = input.nextInt();
        sub = input.nextInt();
        mul = input.nextInt();
        div = input.nextInt();

        result.oper(1,arr.get(0));
        System.out.println(max);
        System.out.println(min);

    }

    private void oper(int i, int value){
        if(i==N){
            max = Math.max(max,value);
            min = Math.min(min,value);
        }
        else{
            if(add>0){
                add--;
                oper(i+1,value+ arr.get(i));
                add++;
            }
            if(sub>0){
                sub--;
                oper(i+1,value- arr.get(i));
                sub++;
            }
            if(mul>0){
                mul--;
                oper(i+1,value* arr.get(i));
                mul++;
            }
            if(div>0){
                div--;
                oper(i+1,value/ arr.get(i));
                div++;
            }
        }

    }


}

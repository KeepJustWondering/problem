package DataStructure;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        int n = input.nextInt();

        Factorial result =new Factorial();
        System.out.println(result.cal(n));

    }

    private int cal(int n){
        if(n<=0)
            return 1;
        else
            return n*cal(n-1);
    }
}

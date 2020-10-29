import java.util.Scanner;

public class Account {

    private int[] account(int money) {
        int list[]= {50000,10000,5000,1000,500,100,50,10,1};

        for(int i=0;i<list.length;i++){
            int before = list[i];

            list[i] = money / list[i];

            money %= before;

        }
        return list;
    }

    public static void main(String args[]){

        Scanner input =new Scanner(System.in);

        System.out.print("금액을 입력하시오 : ");
        int money = input.nextInt();

        Account result = new Account();
        int list[] = result.account(money);
        for(int i=0;i<list.length;i++) {
            System.out.print(list[i]);
        }
    }

}

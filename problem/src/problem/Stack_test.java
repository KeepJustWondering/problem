package DataStructure;
import java.util.Stack;


public class Stack_test {
    public static void main(String[] args){
        Stack_test result = new Stack_test();
        result.goal();
    }
    private void goal(){
        Stack a = new Stack();
        Stack b = new Stack();

        a.push(5);
        a.push(2);
        a.push(3);
        a.push(7);
        a.pop();
        a.push(1);
        a.push(4);
        a.pop();

       while(!a.isEmpty()){//최상단 출력
           b.push(a.pop());
           System.out.print(b.peek()+" ");
       }
        System.out.println();
        while(!b.isEmpty()){//최하단 출력
            System.out.print(b.pop()+" ");
        }


    }
}

package DataStructure;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_test {
    public static void main(String[] args){
        Queue_test result = new Queue_test();
        result.goal();
    }
    private void goal(){
        Queue a= new LinkedList();

        a.add(5);
        a.add(2);
        a.add(3);
        a.add(7);
        a.remove();
        a.add(1);
        a.add(4);
        a.remove();
        while(!a.isEmpty()){//최상단 출력

            System.out.print(a.remove()+" ");

        }
    }
}

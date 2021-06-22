package BinarySearch;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Sequential_Search {
    public static void main(String[] args){
        Sequential_Search result = new Sequential_Search();
        System.out.println("생성할 문자 갯수와 찾으려는 문자열을 입력하시오.");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        String S = input.next();
        String[] str = new String[N];

        System.out.println("원소의 갯수만큼 띄어쓰기로 구분되는 문자열을 입력하시오.");
        for(int i=0;i<N;i++)
            str[i]=input.next();

        result.search(str,S);

    }
    private void search(String[] str,String s){
        for(int i=0;i<str.length;i++){
            if(str[i].equals(s))
                System.out.println(i+1);
        }
    }

}

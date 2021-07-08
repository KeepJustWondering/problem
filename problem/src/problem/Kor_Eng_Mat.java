package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
    private String name;
    private int kor;
    private int eng;
    private int mat;

    public Student(String name, int kor,int eng, int mat){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMat() {
        return mat;
    }
    @Override
    public int compareTo(Student other){
        if (this.kor == other.getKor() && this.eng == other.getEng() && this.mat == other.getMat()) {
            return this.name.compareTo(other.name);
        }
        if (this.kor == other.getKor()&& this.eng == other.getEng()) {
            return Integer.compare(other.getMat(), this.mat);
        }
        if (this.kor == other.getKor()) {
            return Integer.compare(this.eng, other.getEng());
        }
        return Integer.compare(other.getKor(), this.kor);
    }
}

public class Kor_Eng_Mat {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        for(int i =0;i<N;i++){
            String name = input.next();
            int kor = input.nextInt();
            int eng = input.nextInt();
            int mat = input.nextInt();

            students.add(new Student(name,kor,eng,mat));
        }
        Collections.sort(students);

        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i).getName());
        }
    }
}

package problem;


class Point{
    int num;
    char square;
    char dif;
}

public class DartGame {

	  Point[] a = new Point[3];
	  
	    public int Dart(String s) {

	        int answer = 0;
	        int count =0;
	        int i = 0;
	        while(i<s.length()){
	            if(s.charAt(i)=='1' && s.charAt(i+1)=='0') {//10일때
	                a[count] = new Point();
	                a[count].num = 10;
	                i += 2;
	            }
	            else if(s.charAt(i)>='0' && s.charAt(i)<='9') {//숫자일때
	                a[count] = new Point();
	                a[count].num =s.charAt(i)-48;
	                i ++;
	            }
	            else{//문자일떄
	                a[count].square = s.charAt(i);
	                i++;
	                if(i<s.length()) {
	                    if(s.charAt(i)=='*'||s.charAt(i)=='#') {
	                        a[count].dif = s.charAt(i);
	                        i++;
	                    }
	                    count++;
	                }
	            }
	        }
	        int[] b = new int[3];

	        for(int j=0;j<3;j++) {
	            b[j]= a[j].num;

	            if(a[j].square == 'D')
	                b[j] *= b[j];
	            else if(a[j].square == 'T')
	                b[j] *= b[j]*b[j];

	            if(a[j].dif == '*') {
	                b[j] *=2;
	                if(j>0)
	                    b[j-1] *=2;
	            }
	            else if(a[j].dif == '#')
	                b[j] *= -1;

	        }
	      for(int j=0;j<3;j++){
	          answer += b[j];
	      }
	      return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1S2D*3T";
		
		DartGame result = new DartGame();
		System.out.println(result.Dart(s));

	}

}

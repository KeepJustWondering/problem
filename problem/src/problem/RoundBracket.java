package problem;

import java.util.Scanner;

public class RoundBracket {
	
	private boolean Richtig(String s) {
		int i=0;
		
		int judge=0;
		
		while(i<s.length()) {
			
			if(s.charAt(i)=='(')
				judge++;
			else
				judge--;
			
			
			if(judge<0)
				return false;
			
			i++;
		}
		
		if(judge!=0)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s = input.next();
		RoundBracket Result = new RoundBracket();
		System.out.println(Result.Richtig(s));
	}

}

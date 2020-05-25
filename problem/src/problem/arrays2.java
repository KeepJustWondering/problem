package problem;

import java.util.Scanner;

public class arrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int arrays2[][]=new int[n][n];
		
		int y = 1;
		
		for(int x =0;x<2*n;x++) {
			for(int i=0;i<arrays2.length;i++) {
				for(int j = 0; j<arrays2[0].length;j++){
					if(i+j==x)
						{
						arrays2[i][j]=y;
						y++;
						}					
					}
				}
			}
	
		for(int i=0;i<arrays2.length;i++) {
			
			for(int j = 0; j<arrays2[0].length;j++){
				
				System.out.print(arrays2[i][j]+"	");
			}
			
			System.out.println();
			}
		}

}

package problem;

import java.util.Arrays;

public class Budget {

	  public int budget(int[] d, int budget) {
	      int answer = 0;
	      int sum=0;
	      Arrays.sort(d);
	
	      while(sum<budget){
	          sum += d[answer++];
	
	          if(budget<sum)
	            answer += -1;
	           if(answer==d.length)
	                  break;
	      }
	
	      return answer;
	  }
	  public static void main(String[] args) {
		int d[] = {1,3,2,5,4};
		int budget = 9;
		Budget result = new Budget();
		System.out.println(result.budget(d,budget));
		
      }
}

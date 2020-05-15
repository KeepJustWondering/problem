package problem;

public class world_124 {
	
	
	public String world(int n) {
    	
		String s ="";
		int t= 3;
		while(n>0) {
			if(n%3==0) {
				s = 4 + s;
				n= n/3 -1;
			}
			else {
				s = n%t + s;
				n=n/3;
			}
		}
		return s;
	}	  
		
	
	public static void main(String[] args) {
			world_124 result = new world_124();
			for(int i=0;i<4;i++) {
				System.out.println(result.world(i+1));
			}

	}

}

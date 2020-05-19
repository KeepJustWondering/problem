package problem;

import java.util.Arrays;

public class CaesarCipher {
	
	

	
	public String Cipher(String s, int n) {
	     
	       char[] str =s.toCharArray();
			 
			  int j = 0;
		      for(int i=0;i<str.length;i++){
		    	
		    	  for(j=0;j<n;j++) {
		        
		    		  if( str[i]=='z')
		    			  str[i] ='a';
		          
		    		  else if( str[i]=='Z')
		    			  str[i] ='A';
		        
		    		  else if( str[i]==' ')
		    			  str[i]=' ';
		    		  
		    		  else
		    			  str[i]+=1; 
		    	  }
		      }
	       String answer = new String(str);
	      
	      return answer;
	  }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AB";
		int n = 1;
		CaesarCipher result = new CaesarCipher();
		
		System.out.println(result.Cipher(s, n));
		
	}

}

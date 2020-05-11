package problem;

public class Fail {
    public int stage;
    public double fail;

    public Fail(int a, double b) {
        this.stage = a;
        this.fail = b;
    }
    
    
    public static void main(String[] args) {
    	int N=5;
    	int[] stages = {2,1,2,6,2,4,3,3};
    	int[] answer = new int[N];
    	
    	Solution fail = new Solution();
    	answer = fail.solution(N,stages);
    	
    	for(int i : answer) {
    		System.out.print(" "+i);
    	}
    }
}
class Solution {
	
    public int[] solution(int N, int[] stages) {

         Fail[] s = new Fail[N];

        int[] answer = new int[N];

        for(int i=0;i<answer.length;i++) 
            s[i] = new Fail(i+1,Fail(stages,i+1));

        s = Sort(s);
        for(int i=0;i<answer.length;i++) 
            answer[i] = s[i].stage;
        return answer;
    }
    public double Fail(int[] a, int n) {
        int fail=0;
        int reach=0;

        for(int i=0;i<a.length;i++) {
            if(a[i]>n)
                reach++;
            else if(a[i]==n){
                reach++;
                fail++;
            }
        }

        return (double)fail/reach;
    }

    public Fail[] Sort(Fail[] s) {

        for(int j = s.length-1;j>0;j--) {
            for(int i=0;i<j;i++) {
                if(s[i].fail<s[i+1].fail) {
                    Fail t = s[i];
                    s[i] = s[i+1];
                    s[i+1]= t;
                }
                else if(s[i].fail==s[i+1].fail) {
                    if(s[i].stage>s[i+1].stage) {
                            Fail t = s[i];
                            s[i] = s[i+1];
                            s[i+1]= t;
                    }
                }
            }
        }
        return s;
    }
  
}
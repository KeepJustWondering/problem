package problem;

public class uniform {
	
	public static void main(String[] args) {
		int n=30;
		int[] lost = {2,3,5,6,7,8,10,11};
		int[] reserve = {3,4,5,7,8,9};
		
		int plus =0;
	

		for(int i=0;i<reserve.length;i++) {//같은 번호를 가진 학생 색출
			for(int j=0;j<lost.length;j++) {
//				if(lost[j]==-1 && reserve[i]==-1){
//                    continue;
//                }
				if(reserve[i] == lost[j]){
					reserve[i]=-1;
					lost[j]=-1;
					plus++;
				}
			}		
		}
	
		
		for(int i=0;i<reserve.length;i++) {//1차이나는 번호를 가진 학생 색출
			for(int j=0;j<lost.length;j++) {
//				if(lost[j]==-1 && reserve[i]==-1){
//                    continue;
//                }
				if(reserve[i]+1 == lost[j]||reserve[i]-1 == lost[j]){//여분을 가진 학생이 빌려줄 사람이 있는 경우
					reserve[i]=-1;
					lost[j]=-1;
					plus++;
				}
			}		
		}
	
		
		System.out.println(n-lost.length+plus);
	}
}

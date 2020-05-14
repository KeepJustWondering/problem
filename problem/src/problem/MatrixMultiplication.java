package problem;

public class MatrixMultiplication {
	public int[][] Multiplication(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int big = arr1[0].length;


        for(int i=0;i<arr1.length;i++){
            for(int j =0;j<arr2[0].length;j++){

                int count = 0;
                answer[i][j]=0;

                while(count<big){
                    answer[i][j] += arr1[i][count]*arr2[count][j];
                    count++;
                }
            }
        }
        return answer;
    }
	public static void main (String[] args) {
		
		int arr1[][] = {{2,3,2},{4,2,4},{3,1,4}};
		int arr2[][] = {{5,4,3},{2,4,1},{3,1,1}};
		
		MatrixMultiplication result = new MatrixMultiplication();
		int arr3[][] = result.Multiplication(arr1, arr2);
		
		
		for(int i=0;i<arr3.length;i++) {
			for(int j=0;j<arr3[i].length;j++) {
				System.out.print(arr3[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
}

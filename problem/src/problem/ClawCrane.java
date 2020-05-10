package problem;

import java.util.Stack;

public class ClawCrane {
	public void claw(){
		int[][] board = {{1,0,0},{1,0,0},{1,1,1}};
		int[] move = {1,3,1,2,1,1};
		
		Stack<Integer>[] boardStack = new Stack[board[0].length];//���� ȭ�鿡 �ִ� ������ ��Ÿ���� ��ü
		Stack<Integer> basketStack = new Stack();//���� ȭ�鿡�� ����� �ٱ��ϸ� ��Ÿ���� ��ü
		
		insertArray(board,boardStack);//����
		
		System.out.println("����� : "+Count(boardStack,basketStack,move));// ����� ���� ���� ���
		
		while(!basketStack.isEmpty())
			System.out.println(basketStack.pop());//���� �� ���� Ȯ��
		
	}
	
	public Stack<Integer>[] insertArray(int[][] board,Stack<Integer>[] boardStack) {//board�� ���ҵ��� boardStack�� ����
		
		for(int i=0;i<board[0].length;i++) {
			Stack<Integer> stack = new Stack();
			for(int j=board.length-1;j>=0;j--) {
				if(board[j][i]!=0)//0�� �ƴҶ�
					stack.push(board[j][i]);//����
			}
			boardStack[i] = stack;
		}
		return boardStack;
	}
	
	public int Count(Stack[] boardStack, Stack basketStack, int[] move) {
		int count=0;
		for(int i=0;i<move.length;i++) {
			if(!boardStack[move[i]-1].isEmpty()) {//������ ���ϴ� ���ο� ������ ���� �ִ� ���
				if(!basketStack.isEmpty()) {//�ٱ��Ͽ� �̹� ������ �ִ� ���
					if(boardStack[move[i]-1].peek()==basketStack.peek()) {//������ Ȯ��
						boardStack[move[i]-1].pop();
						basketStack.pop();
						count+=2;
					}
					else {//�ٸ��ٸ�
						basketStack.push(boardStack[move[i]-1].pop());
					}
				}
				else {//�ٱ��Ͽ� ������ ���� ��� 
					basketStack.push(boardStack[move[i]-1].pop());
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		ClawCrane result = new ClawCrane();
		result.claw();
	}
	
	
	
}

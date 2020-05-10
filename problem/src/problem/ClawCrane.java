package problem;

import java.util.Stack;

public class ClawCrane {
	public void claw(){
		int[][] board = {{1,0,0},{1,0,0},{1,1,1}};
		int[] move = {1,3,1,2,1,1};
		
		Stack<Integer>[] boardStack = new Stack[board[0].length];//게임 화면에 있는 인형을 나타내는 객체
		Stack<Integer> basketStack = new Stack();//게임 화면에서 집어온 바구니를 나타내는 객체
		
		insertArray(board,boardStack);//삽입
		
		System.out.println("결과는 : "+Count(boardStack,basketStack,move));// 사라진 인형 갯수 출력
		
		while(!basketStack.isEmpty())
			System.out.println(basketStack.pop());//삽입 된 인형 확인
		
	}
	
	public Stack<Integer>[] insertArray(int[][] board,Stack<Integer>[] boardStack) {//board의 원소들을 boardStack에 삽입
		
		for(int i=0;i<board[0].length;i++) {
			Stack<Integer> stack = new Stack();
			for(int j=board.length-1;j>=0;j--) {
				if(board[j][i]!=0)//0이 아닐때
					stack.push(board[j][i]);//삽입
			}
			boardStack[i] = stack;
		}
		return boardStack;
	}
	
	public int Count(Stack[] boardStack, Stack basketStack, int[] move) {
		int count=0;
		for(int i=0;i<move.length;i++) {
			if(!boardStack[move[i]-1].isEmpty()) {//보드의 원하는 라인에 인형이 남아 있는 경우
				if(!basketStack.isEmpty()) {//바구니에 이미 인형이 있는 경우
					if(boardStack[move[i]-1].peek()==basketStack.peek()) {//같은지 확인
						boardStack[move[i]-1].pop();
						basketStack.pop();
						count+=2;
					}
					else {//다르다면
						basketStack.push(boardStack[move[i]-1].pop());
					}
				}
				else {//바구니에 인형이 없는 경우 
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

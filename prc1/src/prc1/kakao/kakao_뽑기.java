package prc1.kakao;
import java.util.Scanner;
import java.util.Stack;

class kakao_�̱� {
    public static int solution(int[][] board, int[] moves) {
    	Stack <Integer> st= new Stack <Integer>(); 
        int answer = 0;
        for(int i=0;i<moves.length;i++) { //move ó�������� ����
        	for(int j=0;j<board.length;j++) { //���� ũ�⸸ŭ ���� ���� Ȯ���ؾ���
        		if(board[j][moves[i]-1]!=0) {
        			if(!st.isEmpty() && st.peek()==board[j][moves[i]-1]) { //�ִ��� �� ��
	        			answer+=2;
	        			st.pop();
        			}
        			else { //���� ��
        				st.push(board[j][moves[i]-1]);
        			}
        			board[j][moves[i]-1]=0;
        			break;
        		}
        	}
        }
        
        return answer;
    }
    public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves));
		
		return ;

	}
}

	

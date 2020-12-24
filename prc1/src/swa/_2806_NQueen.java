package swa;
import java.util.Arrays;
import java.util.*;
public class _2806_NQueen {

	static int answer;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            boolean [][] board = new boolean[n][n];
            for( boolean [] a : board) Arrays.fill(a,true);
			answer=0;
            spread_board(board,0);
            System.out.println("#"+test_case+" "+answer);
		}
	}
    public static void spread_board(boolean [][] board, int start_idx){
     	if(start_idx==board.length) {
            answer++;
            return;   
        }
        for(int i=0;i<board.length;i++){
            	if(board[start_idx][i]) {
                    boolean[][] newBoard = new boolean[board.length][board[0].length];
                    for(int j=0; j<board.length; j++){
                        System.arraycopy(board[j], 0, newBoard[j], 0, board[0].length);
                    }
                    spread(newBoard,start_idx,i);
                    spread_board(newBoard,start_idx+1);
                }
           }
    }
    public static void spread(boolean [][] board, int idx, int idx2){
     	Arrays.fill(board[idx],false);
        int n = board.length;
        for(int k=0;k<board.length;k++) board[k][idx2]=false;
        int i=idx;
        int j=idx2;
        while(i+1<n && j+1<n) board[++i][++j]=false;
        i=idx;
        j=idx2;
        while(i-1>=0 && j-1>=0) board[--i][--j]=false;
        i=idx;
        j=idx2;
        while(i-1>=0 && j+1<n) board[--i][++j]=false;
        i=idx;
        j=idx2;
        while(i+1<n && j-1>=0) board[++i][--j]=false;
    }
}
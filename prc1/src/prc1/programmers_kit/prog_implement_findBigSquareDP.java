package prc1.programmers_kit;

public class prog_implement_findBigSquareDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	public static int solution(int [][]board)
    {
		int n=board.length;
		int m=board[0].length;
		int max_answer=0;
		int [][]dp=new int[n][m];
		if(n>=1) for(int i=0;i<m;i++) {
			dp[0][i]=board[0][i];
			if(dp[0][i]==1) max_answer=1;
		}
		if(n>=2) {
			for(int i=1;i<n;i++) {
	        	for(int j=0;j<m;j++) {
	        		if(board[i][j]==1) dp[i][j]=1;
	        	}
	        }
			
			for(int i=1;i<n;i++) {
	        	for(int j=1;j<m;j++) {
	        		if(board[i][j]==1) dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
	        		max_answer=Math.max(max_answer, dp[i][j]);
	        	}
	        }
			
		}
        
        return max_answer*max_answer;
    }

}

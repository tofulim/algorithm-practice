package prc1.programmers_kit;

public class prog_implement_findBigSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] board = {{0,0,0}}; 
		System.out.println(solution(board));
	}
	static int [][] arr;
	static int answer=0;
	static int tmp_answer=1;
	static int n,m;
	public static int solution(int [][]board)
    {	
		arr=board;
		n=board.length;
		m=board[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j]==1) {
					makeSquare(i,j,j+1,i+1);
					answer=Math.max(answer, tmp_answer);
					if(answer==m || answer==n) return answer*answer;
				}
			}
		}
        return answer*answer;
    }
	public static void makeSquare(int i,int j, int right,int low) {
		if(right>m-1 || low>n-1) return;
		int rot=n-1-low<m-1-right?low-i:right-j;
		for(int k=0;k<rot;k++) {
			if(arr[low][j+k]==0) return ;
		}
		for(int k=0;k<rot+1;k++) {
			if(arr[i+k][right]==0) return;
		}
		
		tmp_answer=(right-j+1);
		makeSquare(i,j,right+1,low+1);
	}
}

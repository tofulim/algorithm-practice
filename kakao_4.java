package prc1;

import java.util.Arrays;

public class kakao_4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] s= {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		System.out.print(solution(s));

	}
	static int cost=0;
	static int mincost=-1;
	static int[] xway = {0,1,0,-1}; //우, 아래, 좌, 위
	static int[] yway = {1,0,-1,0};
	
	public static void dfs(int[][] board,int x,int y, int state) {
		System.out.println("방향 : "+state+"cost :"+cost+"x : "+x+"y :"+y);
    	if(x==board.length-2 && y==board.length-2) {
    		if(mincost==-1) mincost=cost;
    		else if(cost<mincost) {mincost=cost;}
    		cost=0;
    		state=4;
    		
    		return ;
    	}
    	else {
    		for(int i=0;i<4;i++) {
    			if(board[x+xway[i]][y+yway[i]]==1) {//갈 수 있다면
    				board[x+xway[i]][y+yway[i]]=0;
    				int lastc=cost;
    				if(state==4||state==i ) cost+=100;
    				else cost+=600;
    				state=i; //우 아래 좌 위 0 1 2 3
    				dfs(board,x+xway[i],y+yway[i],state);
    				if(x+xway[i]==board.length-2 &&y+yway[i]==board.length-2) {
    					System.out.println("엥"); state=4; return;
    				}
    				board[x+xway[i]][y+yway[i]]=1;
    				cost=lastc;
    				state=4;
    			}
    		}
    	}
    }
	public static int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        int[][] nboard=new int[len+2][len+2];
        for(int i=1;i<=len;i++) {
        	for(int j=1;j<=len;j++) {
        		if(board[i-1][j-1]==1) nboard[i][j]=0; // 못가면 0 갈 수 있으면 1
        		else {
        			nboard[i][j]=1;
        		}
        	}
        }
        dfs(nboard,1,1,4);
        answer=mincost;
        return answer;
    }
}

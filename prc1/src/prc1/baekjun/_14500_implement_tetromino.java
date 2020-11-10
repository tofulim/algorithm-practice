package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _14500_implement_tetromino {
	
	static int answer=0;
	static int dfs_answer=0;
	static int bfs_answer=0;
	static int []x= {0,1,0,-1};
	static int []y= {1,0,-1,0};
	static boolean [][]visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int [][]arr = new int[n][m];
		visit = new boolean[n][m];
		for(boolean[] a: visit) Arrays.fill(a, false);
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visit[i][j]=true;
				dfs_answer=arr[i][j];
				dfs(i,j,arr,1);
				visit[i][j]=false;
				bfs(i,j,arr);
			}
		}
		System.out.println(answer);

	}
	public static void dfs(int i,int j,int [][]arr,int num) {
		if(num==4) {
			answer=answer>dfs_answer?answer:dfs_answer;
			return;
		}
		for(int k=0;k<4;k++) {
			int newx=j+x[k];
			int newy=i+y[k];
			if(newx>=0 && newx<arr[0].length && newy>=0 && newy<arr.length && !visit[newy][newx]) { //경계검사
				dfs_answer+=arr[newy][newx];
				visit[newy][newx]=true;
				dfs(newy,newx,arr,num+1);
				visit[newy][newx]=false;
				dfs_answer-=arr[newy][newx];
			}
		}
	}
	public static void bfs(int i,int j, int[][]arr) {
		bfs_answer=arr[i][j];
		int bfs_min=1000;
		int num=1;
		for(int k=0;k<4;k++) {
			int newx=j+x[k];
			int newy=i+y[k];
			if(newx>=0 && newx<arr[0].length && newy>=0 && newy<arr.length) { //경계검사
				num++;
				bfs_answer+=arr[newy][newx];
				bfs_min=bfs_min<arr[newy][newx]?bfs_min:arr[newy][newx];
			}
		}
		bfs_answer=num==5?bfs_answer-bfs_min:bfs_answer;
		answer=answer>bfs_answer?answer:bfs_answer;
	}

}

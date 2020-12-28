package prc1.baekjun;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class _2178_graph_mazerun {
	static int answer;
	static int [][]arr;
	static boolean [][]visit;
	static int n;
	static int m;
	static int[] x= {1,0,-1,0};
	static int[] y= {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		answer=n*m;
		
		arr= new int[n][m];
		visit = new boolean[n][m];
		
		for(boolean [] a : visit) Arrays.fill(a, false);
		
		for(int i=0;i<n;i++) {
			String s= br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j]=s.charAt(j)-48;
			}
		}
		
		visit[0][0]=true;
		bfs(0,0);
		System.out.println(arr[n-1][m-1]);

	}
//	public static void dfs(int i,int j,int cnt) {
//		if(i==n-1 && j==m-1) {
//			answer=Math.min(answer, cnt);
//			return;
//		}
//		else if(answer==n+m-1) return;
//		for(int k=0;k<4;k++) {
//			int newx=j+x[k];
//			int newy=i+y[k];
//			if(newx<0 || newx>m-1 || newy<0 || newy>n-1 ||visit[newy][newx]) continue;
//			if(arr[newy][newx]==1) {
//				visit[newy][newx]=true;
//				dfs(newy,newx,cnt+1);
//				visit[newy][newx]=false;
//			}
//		}
//	}
	public static void bfs(int i, int j) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.offer(new Dot(i,j));
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			int nowx=tmp.x;
			int nowy=tmp.y;
			for(int k=0;k<4;k++) {
				int newx=nowx+x[k];
				int newy=nowy+y[k];
				if(newx<0 || newx>m-1 || newy<0 || newy>n-1 ||visit[newy][newx] || arr[newy][newx]==0) continue;
				arr[newy][newx]=arr[nowy][nowx]+1;
				visit[newy][newx]=true;
				q.offer(new Dot(newy,newx));
			}
		}
	}
	public static class Dot{
		int x;
		int y;
		public Dot(int y,int x) {
			this.x=x;
			this.y=y;
		}
	}

}

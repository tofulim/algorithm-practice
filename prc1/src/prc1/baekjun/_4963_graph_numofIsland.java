package prc1.baekjun;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class _4963_graph_numofIsland {
	
	static boolean [][] visit;
	static int [][] arr;
	static StringBuilder answer=new StringBuilder();
	static int cnt;
	static int []x= {1,0,-1,0,1,-1,1,-1};
	static int []y= {0,1,0,-1,1,-1,-1,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while(!(s=br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(s);
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			arr= new int[n][m];
			visit = new boolean[n][m];
			for(boolean []a : visit) Arrays.fill(a, false);
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) arr[i][j]=Integer.parseInt(st.nextToken());
			}
			
			cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(!visit[i][j] && arr[i][j]==1) {
						visit[i][j]=true;
						bfs(i,j,n,m);
						cnt++;
					}
				}
			}
			answer.append(cnt+"\n");
		}
		System.out.print(answer.toString());
	}
	
	public static void bfs(int i,int j,int n,int m) {
		Queue <Dot> q = new LinkedList<Dot>();
		q.offer(new Dot(i,j));
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			for(int k=0;k<8;k++) {
				int newx=tmp.x+x[k];
				int newy=tmp.y+y[k];
				if(newx>=0 && newx<m && newy>=0 && newy<n && !visit[newy][newx] && arr[newy][newx]==1) {
					visit[newy][newx]=true;
					q.offer(new Dot(newy,newx));
				}
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

package prc1.baekjun;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class _7576_graph_tomato {
	
	static int answer;
	static int tomato;
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
		m =Integer.parseInt(st.nextToken());
		n =Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		answer=0;
		tomato=0;
		
		visit=new boolean[n][m];
		for(boolean[] a: visit) Arrays.fill(a, false);
		
		Queue <Dot> q = new LinkedList<Dot>();
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int tot=Integer.parseInt(st.nextToken());
				arr[i][j]=tot;
				if(tot==0) tomato++;
				else if(tot==1) {
					q.offer(new Dot(i,j));
					visit[i][j]=true;
				}
			}
		}
		
		bfs(q);
		System.out.println(tomato==0?answer:-1);
		
	}
	public static void bfs(Queue<Dot> q) {
		if(q.isEmpty() || tomato==0) return;
		Queue<Dot> newq=new LinkedList<Dot>();
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			for(int i=0;i<4;i++) {
				int newx=tmp.x+x[i];
				int newy=tmp.y+y[i];
				if(newx<0 || newx>=m || newy<0 || newy>=n || arr[newy][newx]!=0 || visit[newy][newx]) continue;
				visit[newy][newx]=true;
				tomato--;
				newq.offer(new Dot(newy,newx));
			}
		}
		answer++;
		bfs(newq);
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

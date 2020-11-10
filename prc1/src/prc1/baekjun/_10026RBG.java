package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _10026RBG {
	static boolean[][] visit;
	static char[][] arr;
	static Queue<Dot> q=new LinkedList<Dot>();
	static int n;
	static int cnt1;
	static int cnt2;
	static int[] xis= {0,-1,0,1};
	static int[] yis= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q=new LinkedList<Dot>();
		visit=new boolean[n][n];
		arr=new char[n][n];
		for(int i=0;i<n;i++) arr[i]=br.readLine().toCharArray();
		cnt1=0;
		for(int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(visit[i][j]) continue;
				bfs(new Dot(i,j));
				cnt1++;
			}
		}
		for(int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(!visit[i][j]) continue;
				bfs2(new Dot(i,j));
				cnt2++;
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}
	

	static void bfs(Dot d) {
		char color=arr[d.x][d.y];
		visit[d.x][d.y]=true;
		q.offer(d);
		while(!q.isEmpty()) {
			Dot tmp=q.poll();
			int nexti=tmp.x;
			int nextj=tmp.y;
			for(int m=0;m<4;m++) {
				nexti=xis[m]+tmp.x;
				nextj=yis[m]+tmp.y;
				if(nexti>n-1||nexti<0||nextj>n-1||nextj<0) continue;
				if(visit[nexti][nextj]) continue;
				if(arr[nexti][nextj]==color) {
					visit[nexti][nextj]=true;
					q.offer(new Dot(nexti,nextj));
				}	
			}
		}
	}
	static void bfs2(Dot d) {
		char color=arr[d.x][d.y];
		visit[d.x][d.y]=false;
		q.offer(d);
		while(!q.isEmpty()) {
			Dot tmp=q.poll();
			int nexti=tmp.x;
			int nextj=tmp.y;
			for(int m=0;m<4;m++) {
				nexti=xis[m]+tmp.x;
				nextj=yis[m]+tmp.y;
				if(nexti>n-1||nexti<0||nextj>n-1||nextj<0) continue;
				if(!visit[nexti][nextj]) continue;
				if(color==arr[nexti][nextj]||(color=='R'&&arr[nexti][nextj]=='G') || (color=='G'&&arr[nexti][nextj]=='R')) {
					visit[nexti][nextj]=false;
					q.offer(new Dot(nexti,nextj));
				}
			}
		}
	}


}

class Dot {
	public int x;
	public int y;
	Dot(int x,int y){
		this.x=x;
		this.y=y;
	}
}

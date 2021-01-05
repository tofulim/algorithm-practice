package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _2468_bf_safeZone {
	
	static int [][]arr;
	static boolean [][] visit;
	static HashSet<Integer> hs = new HashSet<Integer>();
	static int []x= {0,1,0,-1};
	static int []y= {1,0,-1,0};
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int answer=1;
		
		arr=new int[n][n];
		visit=new boolean[n][n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j]=num;
				hs.add(num);
			}
		}
		
		for(int height : hs) {
			for(boolean[] a : visit) Arrays.fill(a, false);
			int tmp_answer=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visit[i][j] && arr[i][j]>height) {
						visit[i][j]=true;
						bfs(i,j,height);
						tmp_answer++;
					}
				}
			}
			answer=Math.max(answer,tmp_answer);
		}
		System.out.println(answer);
	}
	public static void bfs(int i,int j,int height) {
		Queue <Dot> q = new LinkedList<Dot>();
		q.offer(new Dot(i,j));
		
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			for(int k=0;k<4;k++) {
				int newx=tmp.x+x[k];
				int newy=tmp.y+y[k];
				if(newx>=0 && newx<n && newy>=0 && newy<n &&!visit[newy][newx] && arr[newy][newx]>height) {
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

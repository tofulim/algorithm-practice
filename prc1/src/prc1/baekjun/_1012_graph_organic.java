package prc1.baekjun;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1012_graph_organic {
	
	static boolean [][] visit;
	static int [][] arr;
	static int worm;
	static int []x= {1,0,-1,0};
	static int []y= {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int plant_num = Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			
			visit = new boolean[n][m];
			for(boolean []a : visit) Arrays.fill(a, false) ;
			
			for(int j=0;j<plant_num;j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				arr[y][x]=1;
			}
			
			worm=0;
			for(int ii=0;ii<n;ii++) {
				for(int jj=0;jj<m;jj++){
					if(arr[ii][jj]==1 && !visit[ii][jj]) {
						visit[ii][jj]=true;
						worm++;
						dfs(ii,jj,n,m);
					}
				}
			}
			System.out.println(worm);
		}

	}
	public static void dfs(int i,int j,int n,int m) {
		for(int it=0;it<4;it++) {
			int newx=j+x[it];
			int newy=i+y[it];
			if(newx>=0 && newx<m && newy>=0 && newy<n && arr[newy][newx]==1 && !visit[newy][newx]) {
				visit[newy][newx]=true;
				dfs(newy,newx,n,m);
			}
		}
	}

}

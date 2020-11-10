package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _2667_graph_complex {
	static boolean [][]visit;
	static int []x = {0,1,0,-1};
	static int []y= {1,0,-1,0};
	static int number=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [][] arr = new int[n][n];
		int comp_num=0;
		ArrayList <Integer>al = new ArrayList<>();
		visit = new boolean[n][n];
		
		for(boolean []a : visit) Arrays.fill(a,false);
		
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<s.length();j++) {
				arr[i][j]=s.charAt(j)-48;
			}
		}
		for(int k=0;k<n;k++) {
			for(int kk=0;kk<n;kk++) {
				if(arr[k][kk]==1 && !visit[k][kk]) {
					visit[k][kk]=true;
					comp_num++;
					number=1;
					dfs(k,kk,arr);
					al.add(number);
				}
			}
		}
		Collections.sort(al);
		System.out.println(comp_num);
		for(int comp : al) System.out.println(comp);
	}
	public static void dfs(int i,int j,int[][] arr) {
		for(int m=0;m<4;m++) {
			int newx=j+x[m];
			int newy=i+y[m];
			if(newx>=0 && newx<arr.length && newy>=0 && newy<arr.length &&!visit[newy][newx] && arr[newy][newx]==1 ) {
				number++;
				visit[newy][newx]=true;
				dfs(newy,newx,arr);
			}
		}
	}

}

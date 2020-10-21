package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _1080_greedy_array {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int [][] diff_arr = new int[n][m];
		String [] tmp = new String[m];
		
		int answer=0;
		for(int i=0;i<n;i++) {
			tmp=br.readLine().split("");
			for(int j=0;j<tmp.length;j++) diff_arr[i][j]=Integer.parseInt(tmp[j]);
		}
		for(int i=0;i<n;i++) {
			tmp=br.readLine().split("");
			for(int j=0;j<tmp.length;j++) {
				diff_arr[i][j]=diff_arr[i][j]==Integer.parseInt(tmp[j])?0:1;
			}
		}
		if(n<3 || m<3) {
			
			System.out.println(checker(n,m,diff_arr,0));
			return;
		}
		for(int i=0;i<=n-3;i++) {
			for(int j=0;j<=m-3;j++) {
				if(diff_arr[i][j]==1) { //1일 때 다르므로 함수실행
					diff_arr=changer(i,j,diff_arr);
					answer++;
					}
				}
			}
		if(finalcheck(0,m-3,diff_arr)==-1 || finalcheck(n-3,m-3,diff_arr)==-1) {
			System.out.println("-1");
			return;
		}
		System.out.println(checker(n,m,diff_arr,answer));
		
		
		
		
	}
	public static int checker(int n, int m, int[][] arr, int change_num) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) return -1;
			}
		}
		return change_num;
	}
	
	
	
	public static int[][] changer(int n,int m, int[][] arr) {
		for(int i=n;i<n+3;i++) {
			for(int j=m;j<m+3;j++) {
				arr[i][j]=arr[i][j]==1?0:1;
			}
		}
		return arr;
	}
	public static int finalcheck(int n,int m, int [][] arr) {
		if(n==0) {
			if((arr[n][m]+arr[n][m+1]+arr[n][m+2])==1 || arr[n][m]+arr[n][m+1]+arr[n][m+2]==2 ) return -1;
			else return 0;
		}
		else {
			if((arr[n+2][m]+arr[n+2][m+1]+arr[n+2][m+2])==1 || arr[n+2][m]+arr[n+2][m+1]+arr[n+2][m+2]==2 ) return -1;
			else return 0;
		}
	}

}

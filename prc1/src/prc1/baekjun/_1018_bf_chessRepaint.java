package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _1018_bf_chessRepaint {
	static int n,m,answer;
	static char [][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr=new char[n][m];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) arr[i][j]=s.charAt(j);
		}
		answer=64;
		for(int i=0;i<=n-8;i++) {
			for(int j=0;j<=m-8;j++) {
				paintBoard(i,j);
			}
		}
		System.out.println(answer);
	}
	public static void paintBoard(int i,int j) {
		int b_paint=0;
		int w_paint=0;
		int b_paint2=0;
		int w_paint2=0;
		boolean flag=true;
		
		for(int k=i;k<i+8;k++) {
			for(int kk=j;kk<j+8;kk++) {
				if(flag) {
					if(arr[k][kk]!='B') b_paint++;
					else w_paint2++;
				}
				else {
					if(arr[k][kk]!='W') w_paint++;
					else b_paint2++;
				}
				flag=!flag;  
			}
			flag=!flag;
		}
		answer=Math.min(answer, Math.min(b_paint2+w_paint2,b_paint+w_paint));
	}

}

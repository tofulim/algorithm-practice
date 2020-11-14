package prc1.baekjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10844_dp_easyStairNum {
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub'
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println(9);
			return ;
		}
		arr=new int[101][10];
		for(int i=1;i<10;i++) arr[1][i]=1;
		
		long answer=0;
		dp();
		for(int j=0;j<10;j++) answer+=arr[n][j]; 
		
		System.out.println(answer%1000000000);

	}
	public static void dp() {
		for(int i=2;i<=n;i++) {
			arr[i][0]=arr[i-1][1];
			arr[i][9]=arr[i-1][8];
			for(int j=1;j<9;j++) {
				arr[i][j]=(arr[i-1][j-1]+arr[i-1][j+1])%1000000000;
			}
		}
	}

}
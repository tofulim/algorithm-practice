package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _14501_bruteforce_retire {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [][] arr=new int[n+1][2]; 
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int [] dp = new int[n+1];
		Arrays.fill(dp, 0);
		
		for(int k=1;k<=n;k++) {
			int time=arr[k][0];
			if(time==1) dp[k]=Math.max(dp[k], dp[k-1]+arr[k][1]); //����ġ�� ������ ��
			else {
				if(k+time-1>n) { //�׳��� �ð��� �� Ŀ�� ����� ���Ұ�� �׳��� �Һ�ǰ� �ؾ���
					dp[k]=Math.max(dp[k], dp[k-1]);
					continue;
				}
				dp[k]=Math.max(dp[k], dp[k-1]); //������ ���� ���ٸ� �������� ����
				dp[k+time-1]=Math.max(dp[k+time-1],dp[k-1]+arr[k][1]); //�̷��� ����ݾ�
				//�ڱ��ڽŰ� ���ؼ� ��� ���� �� �̵����� Ȯ��
			}	
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
	

}

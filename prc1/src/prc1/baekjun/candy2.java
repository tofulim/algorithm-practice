package prc1.baekjun;
import java.util.Scanner;
public class candy2{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int candy=sc.nextInt();
		int[] x=new int[n];
		int[] y=new int[n];
		int[] dp=new int[n];
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
			dp[i]=candy-x[i]-y[i];
		}
		
		for(int j=1;j<n;j++) {
			for(int k=0;k<j;k++) {
				if(x[k]<=x[j]&&y[k]<=y[j]&&candy-(x[j]+y[j])!=0) {
					dp[j]=Math.max(dp[k]+candy-(x[j]+y[j]),dp[j]);
					System.out.println(dp[j]);
				}
			}
		}
		int max=0;
		for(int kk=0;kk<n-1;kk++) {
			max=Math.max(dp[kk],dp[kk+1]);
		}
		System.out.println(max);
	}

}

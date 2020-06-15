package prc1; //피보나치임
import java.util.Scanner;

public class binary2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long [] dp=new long[n+1];
		dp[1]=1;dp[0]=0;
		if(n==1) {System.out.println(1); return;}
		else {
			for(int i=2;i<=n;i++) {
				dp[i]=dp[i-1]+dp[i-2];
			}
			System.out.println(dp[n]);
		}
	}

}

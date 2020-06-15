package prc1;
import java.util.Scanner;
public class stairClimbing2579 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int stair=sc.nextInt();
		int[] score=new int[stair+2];
		int[] dp=new int[stair+2];
		for(int i=stair;i>0;i--) {
			dp[i]=score[i]=sc.nextInt();
		}
		boolean flag=false;
		for(int k=3;k<=stair+1;k++) {
			if(dp[k-1]+score[k]>Math.max(score[k-1]+dp[k-2],dp[k-2]+score[k])&&flag==true) {
				flag=false;
				dp[k]=Math.max(score[k-1]+dp[k-2],dp[k-2]+score[k]);
			}
			else {
			dp[k]=Math.max(dp[k-1]+score[k],Math.max(score[k-1]+dp[k-2],dp[k-2]+score[k]));
			if(dp[k-1]+score[k]>Math.max(score[k-1]+dp[k-2],dp[k-2]+score[k])) {flag=true;}
			else {flag=false;}
			}
			System.out.println(k+"-"+dp[k]);
		}
		System.out.println(dp[stair+1]);
	}

}

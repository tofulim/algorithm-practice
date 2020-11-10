package prc1.baekjun;
import java.util.Scanner;
public class stair2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int stair=sc.nextInt();
		int[] score=new int[stair+2];
		int[] dp=new int[stair+2];
		for(int i=stair;i>0;i--) {
			dp[i]=score[i]=sc.nextInt();
		}
		dp[0]=0; dp[2]+=dp[1];
		for(int k=3;k<=stair;k++) {
			dp[k]=Math.max(score[k]+score[k-1]+dp[k-3],dp[k-2]+score[k]);;
		}
		System.out.println(dp[stair]);
	}

}

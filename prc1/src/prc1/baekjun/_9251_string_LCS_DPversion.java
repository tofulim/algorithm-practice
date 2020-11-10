package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _9251_string_LCS_DPversion {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1=br.readLine();
		String s2=br.readLine();
		int [][] dp = new int[s2.length()+1][s1.length()+1];
		for(int []a:dp) Arrays.fill(a, 0); //2차원배열 초기화방법
		for(int i=1;i<=s2.length();i++) {
			for(int j=1;j<=s1.length();j++) {
				if(s2.charAt(i-1)==s1.charAt(j-1)) { //같을 때
					dp[i][j]=Math.max(dp[i-1][j-1]+1,Math.max(dp[i][j-1],dp[i-1][j]));
				}
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		System.out.println(dp[s2.length()][s1.length()]);
		
	}

}

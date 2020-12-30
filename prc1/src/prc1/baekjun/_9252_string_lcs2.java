package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class _9252_string_lcs2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int [][] dp=new int[s1.length()+1][s2.length()+1];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j]=Math.max(dp[i-1][j-1]+1, Math.max(dp[i-1][j], dp[i][j-1]));
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		int lcs=dp[s1.length()][s2.length()];
		
		int x=s1.length();
		int y=s2.length();
		while(!(x==0 || y==0)) {
			if(s1.charAt(x-1) == s2.charAt(y-1)) {
				sb.append(s1.charAt(x-1));
				x--; y--;
			}
			else if(dp[x][y]==dp[x-1][y]) x--;
			else if(dp[x][y]==dp[x][y-1]) y--;
		}
		
		if(lcs==0) System.out.println(0);
		else {
			System.out.print(lcs+"\n"+sb.reverse().toString());
		}
		
	}

}

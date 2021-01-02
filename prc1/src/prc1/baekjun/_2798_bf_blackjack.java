package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2798_bf_blackjack {
	
	static int n,m,answer;
	static int [] arr;
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visit = new boolean[n];
		Arrays.fill(visit, false);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer=0;
		findJack(0,0,0);
		System.out.println(answer);

	}
	public static void findJack(int start,int sum, int card) {
		if(card==3) {
			answer=Math.max(sum, answer);
			return;
		}
		for(int i=start;i<n;i++) {
			if(!visit[i] && sum+arr[i]<=m) {
				visit[i]=true;
				findJack(i,sum+arr[i],card+1);
				visit[i]=false;
			}
		}
		
	}

}

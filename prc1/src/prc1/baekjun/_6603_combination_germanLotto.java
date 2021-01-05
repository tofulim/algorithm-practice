package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class _6603_combination_germanLotto {
	static StringBuilder sb;
	static StringBuilder answer = new StringBuilder();
	static boolean [] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		StringTokenizer st;
		while(!(s=br.readLine()).equals("0")) {
			st = new StringTokenizer(s);
			sb = new StringBuilder();
			int n = Integer.parseInt(st.nextToken());
			visit = new boolean[n];
			Arrays.fill(visit, false);
			int [] arr = new int[n];
			for(int i=0;i<n;i++) {
				int num=Integer.parseInt(st.nextToken());
				arr[i]=num;
			}
//			cycle(0,0,arr, n);
			getCombination(n,arr);
			answer.append(sb.toString()+"\n");
		}
		System.out.print(answer.toString());

	}
	public static void cycle(int idx,int cnt,int [] arr,int n) {
		if(idx==n) return;
		if(cnt==6) {
			for(int i=0;i<n;i++) {
				if(visit[i]) {
					sb.append(arr[i]+" ");
				}
			}
			sb.append("\n");
			return;
		}
		for(int i=idx;i<n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				cycle(i,cnt+1,arr,n);
				visit[i]=false;
			}
		}
		
	}
	public static void getCombination(int n, int[] arr) {
		for(int i=0;i<(1<<n);i++) {
			if(Integer.bitCount(i)==6) {
				for(int j=0;j<n;j++) {
					if((1<<j& i)>0) {
						sb.append(arr[j]+" ");
					}
				}
				sb.append("\n");
			}
		}
	}
}

package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _1182_bf_partSequencesum {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int arr[]=new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		int answer=0;
		
		for(int M=1;M<=N;M++) {
			for (int j = 0; (1 << N) > j; ++j) {
				int sum=0;
				if (Integer.bitCount(j) == M) {
					for (int i = 0; i < N; ++i) {
						if (((1 << i) & j) > 0) {
							sum+=arr[i];
						}
					}
					if(sum==S) answer++;
				}
			}
		}
		System.out.println(answer);
	}

}

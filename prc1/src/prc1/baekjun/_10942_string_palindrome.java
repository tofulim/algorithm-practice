package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _10942_string_palindrome {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int [] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		int q_num = Integer.parseInt(br.readLine());
		for(int j=0;j<q_num;j++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(isPalindrome(arr,start,end)+"\n");
		}
		System.out.print(sb.toString());

	}
	public static int isPalindrome(int [] arr,int start,int end) {
		while(start<end) {
			if(arr[start]!=arr[end]) return 0;
			start++;
			end--;
		}
		return 1;
	}

}

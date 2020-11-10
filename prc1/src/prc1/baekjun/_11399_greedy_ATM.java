package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _11399_greedy_ATM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] time=new int [n];
		
		for(int i=0;i<n;i++) time[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);
		int sum=0;
		int total=0;
		for(int j=0;j<n;j++) {
			sum+=time[j];
			total+=sum;
		}
		System.out.println(total);
	}

}

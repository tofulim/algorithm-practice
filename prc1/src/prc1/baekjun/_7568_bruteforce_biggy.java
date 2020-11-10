package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _7568_bruteforce_biggy {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [][] weight_height =new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weight_height[i][0]=Integer.parseInt(st.nextToken());
			weight_height[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int k=0;k<n;k++) {
			if(k!=n-1) System.out.print(wh_Comparator(k,weight_height)+" ");
			else System.out.print(wh_Comparator(k,weight_height));
		}
		
	}
	public static int wh_Comparator(int index,int [][] arr) {
		int rank=1;
		for(int j=0;j<arr.length;j++) {
			if(j==index) continue;
			if(arr[index][0]<arr[j][0] && arr[index][1]<arr[j][1]) rank++;
		}
		return rank;
	}

}

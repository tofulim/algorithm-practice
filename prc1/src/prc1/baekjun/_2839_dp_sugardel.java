package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _2839_dp_sugardel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int bag5,bag3;
		int rest=0;
		bag5=n/5;
		rest=n%5;
		while(rest%3!=0 && bag5!=-1) {
			bag5--;
			rest+=5;
		}
		if(bag5==-1) System.out.println(-1);
		else {
			bag3=rest/3;
			System.out.println(bag3+bag5);
		}
	}

}

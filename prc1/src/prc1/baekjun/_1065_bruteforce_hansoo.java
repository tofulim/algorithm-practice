package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _1065_bruteforce_hansoo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int answer=0;
		if(n<100) System.out.println(n);
		else {
			answer=99;
			int num=100;
			while(num!=n+1) {
				String num_arr=Integer.toString(num);
				int len=num_arr.length();
				int diff=num_arr.charAt(0)-num_arr.charAt(1);
				boolean flag=true;
				for(int i=1;i<len-1;i++) {
					if(diff==num_arr.charAt(i)-num_arr.charAt(i+1)) continue;
					else {
						flag=false;
						break;
					}
				}
				if(flag==true) answer++;
				num++;
			}
			System.out.println(answer);
		}
	}

}

package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _1541_string_missingGwalho {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int sum;
		if(!s.contains("-") || !s.contains("+")) { //+혹은 -만 있을 때 예외처리
			if(s.contains("-")) {
				String [] arr=s.split("\\-");
				sum=Integer.parseInt(arr[0]);
				for(int i=1;i<arr.length;i++) sum-=Integer.parseInt(arr[i]);
			}
			else {
				String [] arr=s.split("\\+");
				sum=0;
				for(int i=0;i<arr.length;i++) sum+=Integer.parseInt(arr[i]);
			}
			System.out.println(sum);
			return ;
		}
		
		String [] arr=s.split("\\-"); //-를 기준으로 잘라줌
		if(arr[0].contains("+")) { //첫 항을 먼저 계산해서 sum으로 만들어줌
			String [] tmp=arr[0].split("\\+");
			sum=0;
			for(int i=0;i<tmp.length;i++) sum+=Integer.parseInt(tmp[i]);
		}
		else sum=Integer.parseInt(arr[0]);
		for(int i=1;i<arr.length;i++) { //둘째항부터 다 -로 연결돼있으므로 내부를 계속 뺄셈해주기
			if(arr[i].contains("+")) {
				String [] tmp=arr[i].split("\\+");
				for(int j=0;j<tmp.length;j++) sum-=Integer.parseInt(tmp[j]);
			}
			else sum-=Integer.parseInt(arr[i]);
		}
		System.out.println(sum);

	}

}

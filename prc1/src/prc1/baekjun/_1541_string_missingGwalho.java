package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _1541_string_missingGwalho {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int sum;
		if(!s.contains("-") || !s.contains("+")) { //+Ȥ�� -�� ���� �� ����ó��
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
		
		String [] arr=s.split("\\-"); //-�� �������� �߶���
		if(arr[0].contains("+")) { //ù ���� ���� ����ؼ� sum���� �������
			String [] tmp=arr[0].split("\\+");
			sum=0;
			for(int i=0;i<tmp.length;i++) sum+=Integer.parseInt(tmp[i]);
		}
		else sum=Integer.parseInt(arr[0]);
		for(int i=1;i<arr.length;i++) { //��°�׺��� �� -�� ����������Ƿ� ���θ� ��� �������ֱ�
			if(arr[i].contains("+")) {
				String [] tmp=arr[i].split("\\+");
				for(int j=0;j<tmp.length;j++) sum-=Integer.parseInt(tmp[j]);
			}
			else sum-=Integer.parseInt(arr[i]);
		}
		System.out.println(sum);

	}

}

package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _9251_string_LCS {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1=br.readLine();
		String s2=br.readLine();
		int answer=0;
		int answer2=0;
		for(int i=0;i<s1.length();i++) { //1�� ������ ���̸�ŭ ����
			answer2=0;
			String tmp=s2; //���ڿ� ����
			int idx=0; //�ε��� �ʱ�ȭ
			s1=s1.substring(i);
			for(int j=0;j<s1.length();j++) { //1�� ������ ���ҵ��� 2�� ���忡 �ִ���  ��
				idx=tmp.indexOf(s1.charAt(j));
				if(idx>-1) { //�ִٸ� 2�� ã���� �������� ������ �߶���
					tmp=tmp.substring(idx+1);
					answer2++; //ã������ +1
				}
				else continue; //������ ���� 1�� ���ҷ� �Ѿ
			}
			answer=answer>answer2?answer:answer2;
		}
		System.out.println(answer);

	}

}

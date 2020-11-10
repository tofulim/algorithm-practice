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
		for(int i=0;i<s1.length();i++) { //1번 문장의 길이만큼 수행
			answer2=0;
			String tmp=s2; //문자열 복사
			int idx=0; //인덱스 초기화
			s1=s1.substring(i);
			for(int j=0;j<s1.length();j++) { //1번 문장의 원소들이 2번 문장에 있는지  비교
				idx=tmp.indexOf(s1.charAt(j));
				if(idx>-1) { //있다면 2번 찾은곳 다음으로 문장을 잘라줌
					tmp=tmp.substring(idx+1);
					answer2++; //찾았으니 +1
				}
				else continue; //없으면 다음 1번 원소로 넘어감
			}
			answer=answer>answer2?answer:answer2;
		}
		System.out.println(answer);

	}

}

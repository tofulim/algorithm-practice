package prc1.baekjun;
import java.io.*;
import java.util.*;

public class _1139_greedy_wordmath {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashSet<Character> hs = new HashSet();
		int []alpha=new int[26];
		Arrays.fill(alpha, 0);
		for(int i=0;i<n;i++) {
			String nowline=br.readLine();
			int len = nowline.length();
			for(int j=0;j<len;j++) {
				char ch=nowline.charAt(j);
				hs.add(ch);
				alpha[ch-'A']+=Math.pow(10, len-1-j);			
			}
		}
		int[] numarr=new int[hs.size()];
		Object[] tmp = hs.toArray();
		for(int k=0;k<hs.size();k++) {
			numarr[k]=alpha[(char)tmp[k]-'A'];
		}
		Arrays.sort(numarr);
//		System.out.println(Arrays.toString(numarr)); //디버그 코드
		
		int answer=0;
		for(int m=numarr.length-1,val=9;m>=0;m--,val--) {
			answer+=val*numarr[m];
		}
		System.out.println(answer);

	}

}

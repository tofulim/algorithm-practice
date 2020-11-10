package prc1.baekjun;
import java.util.*;
import java.io.*;
public class _1316_string_groupwordchecker {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String group_wordarr[]=new String[n];
		int answer=0;
		for(int i=0;i<n;i++) {
			group_wordarr[i]=br.readLine();
		}
		if(n==1 && group_wordarr[0].length()==1) {
			System.out.println(1);
			return;
		}
		
		HashSet<Character> hs;
		for(int i=0;i<n;i++) {
			boolean flag=true;
			if(group_wordarr[i].length()==1) {
				answer++;
				continue;
			}
			char tmp=group_wordarr[i].charAt(0);
			hs=new HashSet<Character>();
			hs.add(tmp);
			for(int j=1;j<group_wordarr[i].length();j++) {	
				int hs_size=hs.size();
				hs.add(group_wordarr[i].charAt(j));
				if(hs_size==hs.size() && (tmp!=group_wordarr[i].charAt(j))) {
					flag=false;
					break;
				}
				tmp=group_wordarr[i].charAt(j);
			}
			if(flag) answer++;
		}
		System.out.println(answer);
	}

}

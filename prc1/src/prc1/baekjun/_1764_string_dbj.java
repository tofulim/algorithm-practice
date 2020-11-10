package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _1764_string_dbj {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		ArrayList<String> al = new ArrayList<>();
		HashSet <String> never_heardArr=new HashSet<>();
		for(int i=0;i<n;i++) never_heardArr.add(br.readLine());
		
		for(int j=0;j<m;j++) {
			String never_seen=br.readLine();
			if(never_heardArr.contains(never_seen))	al.add(never_seen);
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(String s:al) System.out.println(s);
		
	}

}

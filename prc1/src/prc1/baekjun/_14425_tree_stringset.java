package prc1.baekjun;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _14425_tree_stringset {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<>();
		for(int i=0;i<n;i++) {
			hs.add(br.readLine());
		}
		int answer=0;
		for(int j=0;j<m;j++) {
			if(hs.contains(br.readLine())) answer++;
		}
//		ArrayList<String> al = new ArrayList<>();
//		for(int i=0;i<n;i++) {
//			al.add(br.readLine());
//		}
//		int answer=0;
//		for(int j=0;j<m;j++) {
//			if(al.contains(br.readLine())) answer++;
//		}
		System.out.println(answer);
	}

}

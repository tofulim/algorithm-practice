package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1991_tree_treepatrol {
	static StringBuilder sb1=new StringBuilder();
	static StringBuilder sb2=new StringBuilder();
	static StringBuilder sb3=new StringBuilder();
	static Map <String, List<String>> map;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new HashMap <String, List<String>>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String head= st.nextToken();
			String l = st.nextToken();
			String r = st.nextToken();
			List <String>lrList = new ArrayList<>();
			lrList.add(l);
			lrList.add(r);
			map.put(head, lrList);
		}
		frontPatrol("A");
		midPatrol("A");
		backPatrol("A");
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		System.out.print(sb3.toString());
		
		
	}
	public static void frontPatrol(String input) {
		if(input.equals(".")) return;
		sb1.append(input);
		
		frontPatrol(map.get(input).get(0)); //왼쪽 먼저 순회
		frontPatrol(map.get(input).get(1));
				
	}
	public static void midPatrol(String input) {
		if(input.equals(".")) return;
		
		midPatrol(map.get(input).get(0));
		sb2.append(input);
		midPatrol(map.get(input).get(1));
	}
	public static void backPatrol(String input) {
		if(input.equals(".")) return;
		
		backPatrol(map.get(input).get(0));
		backPatrol(map.get(input).get(1));
		sb3.append(input);
	}

}

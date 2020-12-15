package prc1.baekjun;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11725_tree_findParent { //맵으로 풀었음
	
	static Map <Integer, List<Integer>> map;
	static int [] answer;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		answer = new int[n+1];
		map = new HashMap <Integer,List<Integer>>();
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			if(first>second) {
				int tmp=first;
				first=second;
				second=tmp;
			}
			getParent(first,second);
		}
		StringBuilder sb = new StringBuilder ();
		for(int i=2;i<n;i++) sb.append(answer[i]+"\n");
		System.out.print(sb.toString()+answer[n]);

	}
	public static void getParent(int first, int second) {
		if(first==1) {
			if(map.containsKey(1)) map.get(1).add(second);
			else {
				List <Integer> tmp = new ArrayList<>();
				tmp.add(second);
				map.put(1, tmp);
			}
			answer[second]=1;
			return;
		}
		for(Integer key : map.keySet()) {
			if(map.get(key).contains(first) ||map.get(key).contains(second) ) {
				int parent;
				int child;
				if(map.get(key).contains(first)) {
					parent=first;
					child=second;
				}
				else {
					parent=second;
					child=first;
				}
				if(map.containsKey(parent)) map.get(parent).add(child);
				else {
					List <Integer> tmp = new ArrayList<>();
					tmp.add(child);
					map.put(parent, tmp);
				}
				answer[child]=parent;
				return;
			}
		}
	}

}

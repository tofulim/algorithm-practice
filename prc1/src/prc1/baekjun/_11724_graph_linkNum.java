package prc1.baekjun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class _11724_graph_linkNum {
	
	static HashMap<Integer, ArrayList<Integer>> map;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node_num = Integer.parseInt(st.nextToken());
		int link_num = Integer.parseInt(st.nextToken());
		
		map = new HashMap<Integer, ArrayList<Integer>>();
		visit = new boolean [node_num+1];
		Arrays.fill(visit, false);
		
		for(int i=1;i<=node_num;i++) map.put(i, new ArrayList<Integer>());
		
		for(int j=0;j<link_num;j++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.get(start).add(end);
			map.get(end).add(start);
		}
		
		int answer=0;
		for(int k=1;k<=node_num;k++) {
			if(!visit[k]) {
				answer++;
				visit[k]=true;
				bfs(k);
			}
		}
		
		System.out.println(answer);

	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		while(!q.isEmpty()) {
			ArrayList<Integer> tmp = map.get(q.poll());
			for(int i=0;i<tmp.size();i++) {
				int next=tmp.get(i);
				if(!visit[next]) {
					visit[next]=true;
					q.offer(next);
				}
			}
		}
	}

}

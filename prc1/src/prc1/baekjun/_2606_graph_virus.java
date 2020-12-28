package prc1.baekjun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;

public class _2606_graph_virus {
	
	static boolean []visit;
	static HashMap<Integer, ArrayList<Integer>> map;
	static int answer=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com_num =Integer.parseInt(br.readLine());
		int link_num =Integer.parseInt(br.readLine());
		
		visit=new boolean[com_num+1];
		Arrays.fill(visit, false);
		
		map = new HashMap<Integer,ArrayList<Integer>>();
		
		for(int i=0;i<=com_num;i++) {
			map.put(i,new ArrayList<Integer>());
		}
		
		for(int i=0;i<link_num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			
			map.get(first).add(second);
			map.get(second).add(first);
		}
		visit[1]=true;
		bfs(1);
		System.out.println(answer);
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		while(!q.isEmpty()) {
			ArrayList<Integer> tmp = map.get(q.poll());
			for(int i=0;i<tmp.size();i++) {
				int next_com=tmp.get(i);
				if(!visit[next_com]) {
					visit[next_com]=true;
					q.offer(next_com);
					answer++;
				}
			}
		}
	}

}

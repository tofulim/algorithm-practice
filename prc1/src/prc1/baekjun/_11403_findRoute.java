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

public class _11403_findRoute {
	
	static HashMap<Integer, ArrayList<Integer>> map;
	static boolean [] visit;
	static StringBuilder answer=new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		map=new HashMap<Integer,ArrayList<Integer>>();
		
		visit=new boolean[n];
		Arrays.fill(visit, false);
		
		for(int i=0;i<n;i++) map.put(i,new ArrayList<Integer>());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) map.get(i).add(j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				visit[i]=true;
				answer.append(bfs(i,j)+" ");
				Arrays.fill(visit, false);
			}
			answer.append("\n");
		}
		System.out.println(answer.toString());
		
	}
	public static int bfs(int start, int end) {
		Queue <Integer> q= new LinkedList<Integer>();
		q.offer(start);
		while(!q.isEmpty()) {
			ArrayList<Integer> tmp = map.get(q.poll());
			for(int i=0;i<tmp.size();i++) {
				int num=tmp.get(i);
				if(num==end) return 1;
				if(!visit[num]) {
					q.offer(num);
					visit[num]=true;
				}
			}
		}
		return 0;
	}

}

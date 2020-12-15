package prc1.baekjun;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11725_tree_findParent2 { //bfs & dfs 
	static boolean [] visit;
	static int [] answer;
	static ArrayList <ArrayList<Integer>> al;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visit = new boolean [n+1];
		Arrays.fill(visit, false);
		al = new ArrayList<ArrayList<Integer>>();
		for(int j=0;j<=n;j++) al.add(new ArrayList<Integer>());
		
		answer = new int[n+1];
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			al.get(first).add(second);
			al.get(second).add(first);		
		}
//		getParent_bfs(1);
		getParent_dfs(1);
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<n;i++) sb.append(answer[i]+"\n");
		System.out.print(sb.toString()+answer[n]);

	}
//	public static void getParent_bfs(int start) {
//		Queue<Integer> q = new LinkedList<>();
//		q.offer(start);
//		while(!q.isEmpty()) {
//			int top=q.peek();
//			q.poll();
//			ArrayList<Integer> tmp = al.get(top);
//			for(int i=0;i<tmp.size();i++) {
//				int output=tmp.get(i);
//				if(answer[output]==0) {
//					q.offer(output);
//					answer[output]=top;
//				}
//				
//			}
//		}
//	}
	public static void getParent_dfs(int start) {
		ArrayList<Integer> tmp =al.get(start);
		for(int num : tmp) {
			if(!visit[num]) {
				answer[num]=start;
				visit[num]=true;
				getParent_dfs(num);
			}
		}
	}

}

package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _1260_dfsnbfs {
		static Queue<Integer> q = new LinkedList<Integer>(); //for bfs
		static Boolean[] visit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		visit=new Boolean[n+1];
		Arrays.fill(visit, false);
		int line=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(st.nextToken());
		List [] arr= new ArrayList[n+1];
		for(int i=1;i<=n;i++) arr[i]=new ArrayList<Integer>();
		
		int start_node,end_node;
		for(int i=0;i<line;i++) {
			st=new StringTokenizer(br.readLine());
			start_node=Integer.parseInt(st.nextToken());
			end_node=Integer.parseInt(st.nextToken());
			arr[start_node].add(end_node);
			arr[end_node].add(start_node);
		}
		for(int k=1;k<n+1;k++) Collections.sort(arr[k]);
		visit[start]=true;
		System.out.print(start);
		dfs(start,visit,arr);
		System.out.println();
		
		Arrays.fill(visit, false);
		System.out.print(start);
		visit[start]=true;
		q.offer(start);
		bfs(start,visit,arr);

	}
	
	public static void dfs(int start, Boolean[] visit,List[] arr) {
		for(int j=0;j<arr[start].size();j++) {
			int now=(int)arr[start].get(j);
			if(!visit[now]) {
				visit[now]=true;
				System.out.print(" "+now);
				dfs(now,visit,arr);
			}
		}
	}
	
	public static void bfs(int start, Boolean[] visit,List[] arr) {
		while(!q.isEmpty()) {
			int now=(int)q.poll();
			for(int i=0;i<arr[now].size();i++) {
				int next=(int)arr[now].get(i);
				if(!visit[next]) {
					visit[next]=true;
					System.out.print(" "+next);
					q.offer(next);
				}
			}	
		}
	}

}

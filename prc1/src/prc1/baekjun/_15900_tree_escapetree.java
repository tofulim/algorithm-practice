package prc1.baekjun;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class _15900_tree_escapetree {
	
	static ArrayList<ArrayList<Integer>> al;
	static boolean visit[];
	static int answer=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		visit=new boolean[n+1];
		Arrays.fill(visit, false);
		al=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=n;i++) al.add(new ArrayList<Integer>());
		
		StringTokenizer st;
		for(int i=0;i<n-1;i++) {
			st= new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			al.get(first).add(second);
			al.get(second).add(first);
		}
		visit[1]=true;
		dfs(1,0);
		System.out.println(answer%2==0?"No":"Yes");
	}
	public static void dfs(int start, int cnt) {
		ArrayList<Integer> t_al=al.get(start);
		for(int i=0;i<t_al.size();i++) {
			int next=t_al.get(i);
			if(!visit[next]) {
				visit[next]=true;
				dfs(next,cnt+1);
			}
			else if(t_al.size()==1) answer+=cnt;
		}
	}

}

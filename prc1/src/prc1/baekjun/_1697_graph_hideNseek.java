package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class _1697_graph_hideNseek {
	static int [] visit;
	static int answer;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int seeker = Integer.parseInt(st.nextToken());
		int hider = Integer.parseInt(st.nextToken());
		
		visit = new int[100001];
		if(seeker>=hider) System.out.println(seeker-hider);
		else {
			answer=0;
			visit[seeker]=0;
			bfs(seeker,hider);
		}
	}
	
	public static void bfs(int seeker, int hider) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(seeker);
		while(!q.isEmpty()) {
			int top=q.poll();
			int next;
			for(int i=0;i<3;i++) {
				if(i==0) {
					next=top+1;
				}
				else if(i==1) {
					next=top-1;
				}
				else {
					next=top*2;
				}
				if(next==hider) {
					System.out.println(visit[top]+1);
					return;
				}
				else {
					if(next>=0 && next<100001 && visit[next]==0) {
						q.offer(next);
						visit[next]=visit[top]+1;
					}
				}
			}
		}
	}

}

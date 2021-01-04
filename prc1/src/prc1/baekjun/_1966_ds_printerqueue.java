package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1966_ds_printerqueue {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		PriorityQueue <Integer> pq;
		Queue <Number> q;
		
		for(int i=0;i<tc;i++) {
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int idx=Integer.parseInt(st.nextToken());
			int target=0;
			pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			q = new LinkedList<Number>();
			
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int num=Integer.parseInt(st.nextToken());
				pq.offer(num);
				q.offer(new Number(num,j));
				if(j==idx) target=num;
			}

			int answer=1;
			
			while(pq.peek()!=target) {
				if(q.peek().num!=pq.peek()) {
					q.offer(q.poll());
				}
				else {
					pq.poll();
					q.poll();
					answer++;
				}
			}

			while(q.peek().idx!=idx) {
				if(q.peek().num==target) answer++;
				q.offer(q.poll());
				
			}
			
			sb.append(answer+"\n");
		}
		System.out.print(sb.toString());
	}
	public static class Number{
		int num;
		int idx;
		public Number(int num,int idx) {
			this.num=num;
			this.idx=idx;
		}
	}

}

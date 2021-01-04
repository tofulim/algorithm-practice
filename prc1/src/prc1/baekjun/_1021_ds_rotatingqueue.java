package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class _1021_ds_rotatingqueue {
	static Queue <Integer> q;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine());
		int size=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int answer=0;
		
		q = new LinkedList<Integer> ();
		for(int i=1;i<=size;i++) q.offer(i);
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			answer+=getCost(num);
		}
		
		System.out.println(answer);
	}
	public static int getCost(int num) {
		int answer=0;
		while(q.peek()!=num) {
			q.offer(q.poll());
			answer++;
		}
		q.poll();
		return Math.min(answer, q.size()+1-answer);
	}

}

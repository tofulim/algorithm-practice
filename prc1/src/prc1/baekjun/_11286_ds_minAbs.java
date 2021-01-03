package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class _11286_ds_minAbs {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		
		PriorityQueue<Number> pq = new PriorityQueue<Number>();
//		PriorityQueue<Number> pq2 = new PriorityQueue<Number>(pq.size(),new Comparator<Number>() {
//			@Override
//			public int compare(Number a, Number b) {
//				return a.abs_num-b.abs_num;
//			}
//		});
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num==0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else {
					sb.append(pq.poll().num+"\n");
				}
			}
			else pq.offer(new Number(num));
			
		}
		System.out.print(sb.toString());

	}
	public static class Number implements Comparable<Number>{
		int num;
		int abs_num;
		public Number(int num) {
			this.abs_num=Math.abs(num);
			this.num=num;
		}
		@Override
		public int compareTo(Number a) {
			if(this.abs_num==a.abs_num) {
				return this.num-a.num;
			}
			return this.abs_num-a.abs_num;
		}
	}
	

}

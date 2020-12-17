package prc1.baekjun;
import java.io.*;
import java.util.*;

public class _10845_que_queue {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int tail=-1;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String command=st.nextToken();
			if(command.equals("push")) {
				int num=Integer.parseInt(st.nextToken());
				q.offer(num);
				tail=num;
			}
			else {
				switch(command) {
					case ("pop"):
						sb.append((q.isEmpty()==true?-1:q.poll())+"\n");
						break;
					case ("size"):
						sb.append(q.size()+"\n");
						break;
					case ("empty"):
						sb.append((q.isEmpty()==true?1:0)+"\n");
						break;
					case ("front"):
						sb.append((q.peek()!=null?q.peek():-1)+"\n");
						break;
					case ("back"):
						sb.append((q.peek()!=null?tail:-1)+"\n");
						break;
				}
			}
			
		}
		System.out.print(sb.toString());

	}

}
package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _15828_stack_router {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		while(true) {
			int num=Integer.parseInt(br.readLine());
			if(num==-1) break;
			if(num==0) q.pop();
			else if(q.size()<n) q.add(num);
		}
		if(q.isEmpty()) System.out.println("empty");
		else {
			System.out.print(q.peek());
			q.pop();
			while(!q.isEmpty()) {
				System.out.print(" "+q.peek());
				q.pop();
			}
		}
	}

}

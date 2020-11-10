package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _10773_string_zero {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Stack <Integer> st = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			int input=Integer.parseInt(br.readLine());
			if(input!=0) st.push(input);
			else st.pop();
		}
		int answer=0;
		while(!st.isEmpty()) {
			answer+=st.peek();
			st.pop();
		}
		System.out.println(answer);
	}

}

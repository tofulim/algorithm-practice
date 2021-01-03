package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class _1874_ds_stackSequence {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<Integer>();
		int num=1;
		
		for(int i=0;i<n;i++) {
			int input=Integer.parseInt(br.readLine());
			while(st.isEmpty() || st.peek()!=input) {
				if(num>n) {
					System.out.println("NO");
					return;
				}
				st.push(num);
				sb.append("+\n");
				num++;
			}
			sb.append("-\n");
			st.pop();
		}
		System.out.print(sb.toString());
		

	}

}

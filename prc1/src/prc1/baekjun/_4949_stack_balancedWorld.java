package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class _4949_stack_balancedWorld {
	
	static StringBuilder answer=new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(!(s=br.readLine()).equals(".")) {
			answer.append(stringGetter(s)+"\n");
		}
		System.out.print(answer.toString());

	}
	public static String stringGetter(String s) {
		Stack <Character> st = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='(' || c=='[') st.push(c);
			else if(c==')') {
				if(!st.isEmpty() && st.peek()=='(') st.pop();
				else return "no";
			}
			else if(c==']') {
				if(!st.isEmpty() && st.peek()=='[') st.pop();
				else return "no";
			}
		}
		if(st.isEmpty()) return "yes";
		else return "no";
	}

}
package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class _2504_ds_valOfgwalho {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack <String> st = new Stack<String>();
		
		String input = br.readLine();
		int answer=0;
		int onum=0;
		int vnum=0;
		for(int i=0;i<input.length();i++) {
			String c = input.charAt(i)+"";
			int tmp=0;
			if(c.equals(")")) {
				if(onum==0 || st.isEmpty()) {
					System.out.println(0);
					return;
				}
				while(!st.peek().equals("(")) {
					if(st.peek().equals("[")) {
						System.out.println(0);
						return;
					}
					tmp+=Integer.parseInt(st.pop());
				}
				st.pop();
				onum--;
				st.push(tmp==0?"2":tmp*2+"");
			}
			else if(c.equals("]")) {
				if(vnum==0 || st.isEmpty()) {
					System.out.println(0);
					return;
				}
				while(!st.peek().equals("[")) {
					if(st.peek().equals("(")) {
						System.out.println(0);
						return;
					}
					tmp+=+Integer.parseInt(st.pop());
				}
				st.pop();
				vnum--;
				st.push(tmp==0?"3":tmp*3+"");
			}
			else if(c.equals("(")) {
				st.push(c);
				onum++;
			}
			else if(c.equals("[")) {
				st.push(c);
				vnum++;
			}
		}
		for(String s : st) {
			if(s.equals("(") || s.equals("[")) {
				System.out.println(0);
				return;
			}
			answer+=Integer.parseInt(s);
		}
		System.out.println(answer);
	}

}

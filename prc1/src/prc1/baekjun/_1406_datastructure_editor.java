package prc1.baekjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1406_datastructure_editor {
	
	static int string_len;
	static int curser_loc;
	static Stack <Character> origin_stack;
	static Stack <Character> reverse_stack;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input_string = new StringBuilder(br.readLine());
		origin_stack = new Stack<>(); 
		reverse_stack = new Stack<>();
		
		for(int i=0;i<input_string.length();i++) origin_stack.push(input_string.charAt(i));
		
		int n =Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			char []in = br.readLine().toCharArray();		
			if(in.length==1) LRD(in[0]);
			else insert(in[2]);
		}
		while(!origin_stack.isEmpty()) reverse_stack.push(origin_stack.pop());
		StringBuilder answer= new StringBuilder();
		while(!reverse_stack.isEmpty()) answer.append(reverse_stack.pop());
		
		System.out.println(answer.toString());
		
	}
	
	public static void LRD(char command) {
		if(command=='L') {
			if(!origin_stack.isEmpty()) {
				reverse_stack.push(origin_stack.pop());
			}
		}
		else if(command=='D') {
			if(!reverse_stack.isEmpty()) {
				origin_stack.push(reverse_stack.pop());
			}
		}
		else {
			if(!origin_stack.isEmpty()) origin_stack.pop();
		}
	}
	
	public static void insert(char insert_char) {
		origin_stack.push(insert_char);
	}
}

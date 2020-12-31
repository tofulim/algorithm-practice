package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class _9935_string_stringBomb {

//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = br.readLine();
//		String bomb = br.readLine();
//		StringBuilder sb = new StringBuilder();
//		Stack <Character> st = new Stack<Character>();
//		
//		int blen=bomb.length();
//		
//		for(int i=0;i<s.length();i++) {
//			st.push(s.charAt(i));
//			
//			int s_size=st.size();
//			
//			if(s_size>=blen) {
//				boolean flag=true;
//				for(int j=0;j<blen;j++) {
//					if(st.get(s_size-blen+j)!=bomb.charAt(j)) {
//						flag=false;
//						break;
//					}
//				}
//				if(flag) {
//					for(int j=0;j<blen;j++) st.pop();
//				}
//			}
//		}
//		for(Character c : st) sb.append(c);
//		
//		System.out.println(sb.length()>0?sb.toString():"FRULA");
//	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		StringBuilder sb = new StringBuilder();
		ArrayList<Character> al = new ArrayList<Character>();
		
		int blen=bomb.length();
		
		for(int i=0;i<s.length();i++) {
			al.add(s.charAt(i));
			
			int al_size=al.size();
			
			if(al_size>=blen) {
				boolean flag=true;
				for(int j=0;j<blen;j++) {
					if(al.get(al_size-blen+j)!=bomb.charAt(j)) {
						flag=false;
						break;
					}
				}
				if(flag) {
					for(int j=0;j<blen;j++) al.remove(al_size-1-j);
				}
			}
		}
		for(Character c : al) sb.append(c);
		
		System.out.println(sb.length()>0?sb.toString():"FRULA");
	}

}

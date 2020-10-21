package prc1.programmers_kit;
import java.util.*;
public class prog_20kakao_gwalho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "()))((()";
		solution(p);
	}
	public static String solution(String p) {
        return cycle(p);
    }
	public static String cycle(String s) {
		String v,u;
		if(s=="") return ""; //0
		else {//1 쪼개기
			Stack st = new Stack<Character>();
			char start=s.charAt(0);
			st.push(start);
			int i;
			for(i=1;i<s.length();i++) { //u,v찾는 과정
				if(s.charAt(i)!=start) {
					st.pop();
				}
				else {
					st.push(start);
				}
				if(st.isEmpty()) break;
			}
			u=s.substring(0,i+1);
			v=i==s.length()-1?"":s.substring(i+1);
			if(start=='(') { //2-1 올바른 괄호일때
				return u+cycle(v);
			}
			else { //2-2 올바른 괄호가 아닐 때
				String tmp="(";
				tmp+=cycle(v);
				tmp+=")";
				String reverse=u.substring(1,u.length()-1);
				for(int j=0;j<reverse.length();j++) tmp+=reverse.charAt(j)=='('?")":"(";
				return tmp;
			}
		}
	}

}

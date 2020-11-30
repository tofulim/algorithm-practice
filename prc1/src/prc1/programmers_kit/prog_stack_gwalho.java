package prc1.programmers_kit;

public class prog_stack_gwalho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="()()";
		System.out.println(solution(s));
	}
	public static boolean  solution(String s) {
        char L='(';
        int cnt=0;
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)==L) cnt++;
        	else cnt--;
        	if(cnt<0) return false;
        }
        
        return cnt==0?true:false;
    }

}

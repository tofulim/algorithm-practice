package prc1.programmers_kit;

public class prog_practice_getMidChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("asd");
	}
	public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len=s.length();
        if(len%2==0) sb.append(s.charAt((len/2)-1)); 
        sb.append(s.charAt(len/2));
        
        return sb.toString();
    }

}

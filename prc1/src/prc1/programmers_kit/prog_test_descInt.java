package prc1.programmers_kit;
import java.util.Arrays;
public class prog_test_descInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(131));
	}
	public static long solution(long n) {
        String[] arr = (n+"").split("");
        Arrays.sort(arr,(a,b)-> b.compareTo(a));
        StringBuilder sb = new StringBuilder ();
        for(String s:arr) sb.append(s);
        return Long.parseLong(sb.toString()); 
    }
	static String res;
    public static int solution2(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }

}

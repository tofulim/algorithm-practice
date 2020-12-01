package prc1.programmers_kit;
import java.util.Arrays;
import java.util.Comparator;

public class prog_test_sortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s= {"abce", "abcd", "cdx"};
		System.out.println(Arrays.toString(solution(s,2)));

	}
	public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings,new Comparator <String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		int comp=s1.charAt(n) - s2.charAt(n);
        		if(comp==0) comp=s1.compareTo(s2);
                return comp;
            }
        });
//        Arrays.sort(
//        		strings, (s1,s2) -> {
//        			int comp=s1.charAt(n) - s2.charAt(n);
//        			if(comp==0) comp=s1.compareTo(s2);
//        			return comp;
//        		});
        
        return strings;
    }
	public static String solution2(String s) {
        char[] cs=s.toCharArray();
        
        Arrays.sort(cs, new Comparator <Character>(){
			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
        });
        return cs.toString();
    }

}

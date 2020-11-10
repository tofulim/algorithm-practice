package prc1.programmers_kit;
import java.util.*;
public class prog_sort_2 {

	public static void main(String[] args) {
		int [] d= {0,0,0};	
		solution(d);
		// TODO Auto-generated method stub

	}
	public static String solution(int[] numbers) {
        String answer="";
        String [] tmp=new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
        	tmp[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(tmp, (o1,o2)-> (o1+o2).compareTo(o2+o1));
        if(tmp[numbers.length-1].equals("0")) {
        	return "0";
        }
        for(int i=numbers.length-1;i>=0;i--) {
        	answer+=tmp[i];
        }
        System.out.println(answer);
        return answer;
    }

}

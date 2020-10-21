package prc1.programmers_kit;
import java.util.*;
public class prog_sort_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] c = {3, 0, 6, 1, 5};
		solution(c);
		
	}
	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--) {
        	if(citations[i]>answer) {
        		answer++;
        	}
        	else {
        		break;
        	}
        }
        if(citations[citations.length-1]==0) return 0;
        System.out.println(answer);
        return answer;
    }

}

package prc1.programmers_kit;
import java.util.*;
public class prog_questack_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] p = {1, 2, 3, 2, 3};
		solution(p);

	}
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time;
        for(int i=0;i<prices.length-1;i++) {
        	time=1;
        	for(int j=i+1;j<prices.length;j++) {
        		if(prices[i]>prices[j]||j==prices.length-1) {
        			answer[i]=time;
        			break;
        		}
        		else time++;
        		
        	}
        }
        answer[prices.length-1]=0;
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

}

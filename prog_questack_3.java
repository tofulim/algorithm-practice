package prc1.programmers_kit;
import java.util.*;
public class prog_questack_3 {
 //못풀었음 자바로
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        Queue <Integer> q=new LinkedList <>();
        for(int i=0;i<progresses.length;i++) {
        	q.offer(progresses[i]);
        }
        int cnt=0;
        int val;
        for(int i=0;i<progresses.length;i++) {
        	val=q.peek();
        	if()
        	while(val<100) {
        		val+=speeds[i];
        	}
        	cnt++;
        }
        
        return answer;
    }

}

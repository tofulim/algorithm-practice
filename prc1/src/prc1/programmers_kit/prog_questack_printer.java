package prc1.programmers_kit;
import java.util.*;
public class prog_questack_printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	class Index{
		int idx;
		int val;
		public Index(int val, int idx) {
			this.val=val;
			this.idx=idx;
		}
	}
	public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue <Index> q=new LinkedList <>();
        for(int i=0;i<priorities.length;i++) {
        	q.offer(new Index(priorities[i],i));
        }
        Arrays.sort(priorities);
        int printidx=-1;
        int len=priorities.length-1;
        while(printidx!=location) {
        	Index i = q.peek();
        	if(q.peek().val<priorities[len]) {
        		q.offer(i);
        		q.poll();
        	}
        	else {
        		printidx=i.idx;
        		answer++;
        		q.poll();
        		len--;
        	}
        }
        
        return answer;
    }

}

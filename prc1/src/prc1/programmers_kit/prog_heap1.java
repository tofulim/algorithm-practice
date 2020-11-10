package prc1.programmers_kit;
import java.util.PriorityQueue;
import java.util.Comparator;
public class prog_heap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1, 2, 3, 9, 10, 12};
		int k=7;
		solution(arr,k);
	}
	public static int solution(int[] scoville, int K) {
        int answer = 0;
//        PriorityQueue <Integer> pq=new PriorityQueue <>(new Comparator<Integer>() {
//        	public int compare(Integer w1, Integer w2) {
//				return w2.compareTo(w1); //descendant order  큰수부터 빼고 싶을 때
//			}
//        });
        PriorityQueue <Integer> pq=new PriorityQueue <>(); //작은수 부터 빼고 싶을 때
        for(int i=0;i<scoville.length;i++) {
        	pq.offer(scoville[i]);
        }
        int newFood;
        while(!pq.isEmpty()) {
        	System.out.println(pq.poll());
        }
        while(pq.peek()<K) {
        	
        	if(pq.size()==1) {
        	return -1;
        	}
//        	System.out.println("젤작은수1 : "+pq.peek());
        	newFood=pq.poll();
//        	System.out.println("젤작은수2 : "+pq.peek());
        	newFood+=pq.poll()*2;
        	pq.offer(newFood);
        	answer++;
        }
        System.out.println(answer);
        return answer;
    }

}

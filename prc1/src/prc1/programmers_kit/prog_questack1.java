package prc1.programmers_kit;
import java.util.*;


public class prog_questack1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	    	Queue<Truck> waiting = new LinkedList<Truck>();
	    	Queue<Truck> bridge = new LinkedList<Truck>();
	    	for(int i=0;i<truck_weights.length;i++) {
	    		waiting.offer(new Truck(truck_weights[i],0));
	    	}
	    	int time=0;
	    	int nw=0;
	    	while(!waiting.isEmpty()||!bridge.isEmpty()) {
	    		time++;
	    		if(!bridge.isEmpty()) { //���Ը� ���� �ʾ��� ��
	    			Truck t = bridge.peek(); //÷ ���� �� �־���
	    			if(time-t.time>=bridge_length) {
	    				nw-=t.weight;
	    				bridge.poll();
	    			}
	    		}
				
				if(!waiting.isEmpty()) { //���� ��ٸ��� ���� ����
					if(nw+waiting.peek().weight<=weight) {
						Truck t = waiting.poll();
						nw+=t.weight;
						bridge.offer(new Truck(t.weight,time));
					}
	    		}
	    		
	    	}
	        return time;
	    }
	}
	class Truck{
		int time;
		int weight;
		public Truck(int weight,int time) {
			this.time=time;
			this.weight=weight;
		}
			
	}

}

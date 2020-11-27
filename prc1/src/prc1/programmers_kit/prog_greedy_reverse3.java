package prc1.programmers_kit;

import java.util.ArrayList;

public class prog_greedy_reverse3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(125));
	}
	public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> num_al=new ArrayList<Integer>();
        while(n>0) { //3진법 만들면서 거꾸로 넣어줌으로서 거꾸로 까지
        	num_al.add(n%3);
        	n/=3;
		}
        int len=num_al.size();
        for(int num : num_al) answer+=num*Math.pow(3, --len);
        return answer;
    }

}

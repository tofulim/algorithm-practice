package prc1.programmers_kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class prog_greedy_trainingCloth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []lost = {2,4};
		int []reserve= {1,3,5};
		System.out.println(solution(5,lost,reserve));

	}
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> lost_al = new ArrayList<Integer>(Arrays.stream(lost).boxed().collect(Collectors.toList()));
        ArrayList<Integer> reserve_al = new ArrayList<Integer>(Arrays.stream(reserve).boxed().collect(Collectors.toList()));
        
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(lost[i]==reserve[j]) {
        			int idx=lost_al.indexOf(lost[i]);
        			lost_al.remove(idx);
        			idx=reserve_al.indexOf(lost[i]);
        			reserve_al.remove(idx);
        		}
        	}
        }
        System.out.println(lost_al);
        System.out.println(reserve_al);
        int lost_num=lost_al.size();
        
        for(int i=0;i<lost_al.size();i++) {
        	for(int j=0;j<reserve_al.size();j++) {
        		System.out.println("rs"+reserve_al.size());
        		if(lost_al.get(i)==(reserve_al.get(j)+1) || lost_al.get(i)==(reserve_al.get(j)-1)) {
        			reserve_al.remove(j);
        			answer++;
        			break;
        		}
        	}
        }
        return n-lost_num+answer;
    }

}

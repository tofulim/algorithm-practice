package prc1.programmers_kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class prog_greedy_helpboat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {70, 50, 50,80};
		System.out.println(solution(arr,100));
	}
	public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length-1;
        int start=0;
        while(start<len) {
        	if(people[start]+people[len]<=limit) {
        		start++;
        		len--;
        	}
        	else {
        		len--;
        	}
        }
        
        return people.length-start;
    }

}

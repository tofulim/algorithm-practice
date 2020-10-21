package prc1.programmers_kit;
import java.util.*;
public class prog_greedy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int a[]= {2,4};
		int b[]= {3};
		solution(n,a,b);

	}
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(lost[i]==reserve[j]) answer++;
        	}
        }
        int l=0;
        int r=0;
        while(r<reserve.length && l<lost.length) {
        	if(Math.abs(lost[l]-reserve[r])==1) {
        		r++;
        		l++;
        		answer++;
        	}
        	else if(lost[l]>reserve[r]) {
        		r++;
        	}
        	else if(reserve[r]>lost[l]) {
        		l++;
        	}
        	else if(lost[l]==reserve[r]) {
        		r++; l++;
        	}
        }
        return answer;
    }

}

package prc1.programmers_kit;
import java.util.*;
public class prog_test_124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		solution(n);
	}
	public static String solution(int n) {
        int [] answer;
        int level=1;
        int sum=0;
        int diff=0; //차이 - 앞으로 가야할 거리
        while(true) {
        	sum+=(int) Math.pow(3,level);
        	if(n<=sum) {
        		sum-=(int)Math.pow(3, level);
        		diff=n-sum-1;
        		break;
        	}
        	level++;
        }
        answer=new int[level];
        for(int i=0;i<level;i++) answer[i]=1;
        for(int i=0;i<diff;i++) {
        	if(answer[level-1]==1) answer[level-1]=2;
        	else if(answer[level-1]==2) answer[level-1]=4;
        	else { //4일 때
        		int j;
        		for(j=level-1;j>0;j--) {
        			if(answer[j]==4) continue;
        			else break;
        		}
        		answer[j]=answer[j]==1?2:4;
        		for(j=j+1;j<level;j++) answer[j]=1;
        	}
        }
        String ans=Arrays.toString(answer).replaceAll("[^0-9]","");
  
        return ans;
    }

}

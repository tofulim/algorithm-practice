package prc1.programmers_kit;
import java.util.*;
public class prog_test_124bystring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=11;
		solution(n);
	}
	public static String solution(int n) {
        StringBuilder answer;
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
        String answer2="";
        for(int i=0;i<level;i++) answer2+=1;
        answer=new StringBuilder(answer2);
        for(int i=0;i<diff;i++) {
        	if(answer.charAt(level-1)=='1') answer.setCharAt(level-1,'2');
        	else if(answer.charAt(level-1)=='2') answer.setCharAt(level-1,'4');
        	else { //4일 때
        		int j;
        		for(j=level-1;j>0;j--) {
        			if(answer.charAt(j)=='4') continue;
        			else break;
        		}
        		char tmp=answer.charAt(j)=='1'?'2':'4';
        		answer.setCharAt(j, tmp);
        		for(j=j+1;j<level;j++) answer.setCharAt(j,'1');
        	}
        }

        System.out.println(answer.toString());
        return answer.toString();
    }

}

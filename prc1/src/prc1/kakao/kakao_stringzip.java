package prc1.kakao;
import java.util.*;

public class kakao_stringzip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcabcdedd";
		solution(s);

	}
	public static int solution(String s) {
        int answer = s.length();
        int len=s.length();
        int start_idx=0;
        int end_idx=0;
        for(int m=1;m<len/2;m++) {
        	System.out.println(m+"일때");
        	String new_s="";
        	int cnt=1;
            start_idx=m;
            end_idx=len-1;
            String now=s.substring(0,m);
        	while(start_idx<=end_idx) {
        		System.out.print("r");
        		
        		if(s.substring(start_idx).startsWith(now)) {
        			System.out.print(s.substring(start_idx));
        			cnt++;
        			start_idx+=m;
        			
        		}
        		else { //다음 것과 다를 때
        			new_s+=cnt+now;
        			now=s.substring(start_idx,start_idx+m);
        			System.out.println("다르기 때문에 변경"+now);
        			cnt=1;
        			start_idx+=m;
        		}
        		if(start_idx+m-1>end_idx) break;

        	}
        	
        	System.out.println("그 인덱스"+start_idx+":"+m);
        	System.out.println("추가"+s.substring(start_idx-m));
        	if(s.substring(start_idx-m).length()==m) new_s+=cnt+now; 
        	else {
        		new_s+=s.substring(start_idx-m);
        	}
        	
        	if(answer>new_s.length()) answer=new_s.length();
        	System.out.println("답-"+new_s);
        }
        System.out.println("답="+answer);
        return answer;
    }

}

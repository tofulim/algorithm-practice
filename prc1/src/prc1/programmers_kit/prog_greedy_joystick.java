package prc1.programmers_kit;

import java.util.Arrays;

public class prog_greedy_joystick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("BBBAAAB"));
		
	}
	public static int solution(String name) {
        int answer = 0;
        int now_idx=0;
        boolean []visit = new boolean[name.length()];
        Arrays.fill(visit, false);
        int rest_alp=name.length();
        for(int i=0;i<name.length();i++) {
        	if(name.charAt(i)=='A') {
        		visit[i]=true; 
        		rest_alp--;
        	}
        }
        while(true) {
        	if(!visit[now_idx]) {
        		char now_char=name.charAt(now_idx);
        		if(now_char-'A'<91-now_char) { //위측이 더 빠름
        			answer+=now_char-'A';
        		}
        		else answer+=91-now_char;
        		visit[now_idx]=true;
        		rest_alp--;
        	}
        	if(rest_alp==0) break; //끝났으면 끝냄
        	else {
        		int left_cnt=0;
        		int right_cnt=0;
        		int lidx=now_idx;
        		int ridx=now_idx;
        		while(visit[lidx]) {
        			if(lidx==0) lidx=name.length()-1;
        			else lidx--;
        			left_cnt++;
        		}
        		while(visit[ridx]) {
        			if(ridx==name.length()-1) ridx=0;
        			else ridx++;
        			right_cnt++;
        		}
        		if(right_cnt<=left_cnt) {
        			answer+=right_cnt;
        			now_idx=ridx;
        		}
        		else {
        			answer+=left_cnt;
        			now_idx=lidx;
        		}
        	}
        }
        return answer;
    }

}

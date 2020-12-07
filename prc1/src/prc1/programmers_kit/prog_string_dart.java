package prc1.programmers_kit;

import java.util.Arrays;

public class prog_string_dart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dart="1D2S#10S";
		System.out.println(solution(dart));
	}
	public static int solution(String dartResult) {
        int answer = 0;
        int score[]=new int[3];
        int idx=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<dartResult.length();i++){
            char now=dartResult.charAt(i);
            if(now>=48 && now<=57){
                sb.append(now);
            }
            else if(now=='*' || now=='#'){
                if(now=='*') {
                    if(idx==1){
                        score[idx]*=2;
                    }
                    else {
                        score[idx-1]*=2;
                        score[idx-2]*=2;
                    }
                    
                }
                else score[idx-1]=-score[idx-1];
            }
            else {
            	score[idx]=Integer.parseInt(sb.toString());
            	sb=new StringBuilder();
                int level=now=='S'?1:now=='D'?2:3;
                score[idx]=(int)Math.pow(score[idx++],level);
            }
        }
        System.out.println(Arrays.toString(score));
        for(int sc: score) answer+=sc;
        return answer;
    }

}

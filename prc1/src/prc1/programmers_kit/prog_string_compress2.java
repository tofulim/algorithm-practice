package prc1.programmers_kit; //https://programmers.co.kr/learn/courses/30/lessons/17684

import java.util.ArrayList;
import java.util.Arrays;

public class prog_string_compress2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "KAKAO";
		System.out.println(Arrays.toString(solution(msg)));
	}
	public static int[] solution(String msg) {
        int[] answer;
        ArrayList <Integer> tmp_answer=new ArrayList<>();
        ArrayList <String> al = new ArrayList<>();
        al.add("#");
        for(int i=0;i<26;i++) al.add(Character.toString(65+i));
        int j=0;
        while(j<=msg.length()-1) {
        	String input = msg.charAt(j)+"";
        	String now=input;
        	int j_move=1;
        	boolean flag=false;
        	while(al.contains(input)) {
        		now=new String(input);	
        		if(j+j_move<msg.length()) {
        			input=input.concat(msg.charAt(j+j_move)+"");
        			j_move++;
        		}
        		else {
        			flag=true;
        			break;
        		}
        		System.out.print("d");
        	}
        	if(al.contains(input)) {
        		System.out.println("1");
        		
        		tmp_answer.add(al.indexOf(input));
        	}
        	else {
        		System.out.println("2");
        		tmp_answer.add(al.indexOf(now));
        		al.add(input);
        	}
        	if(flag) break;
        	j=j_move<=2?j+1:j+j_move-1;
        	System.out.println(Arrays.toString(al.toArray()));
        }
        System.out.println("size");
        answer = new int[tmp_answer.size()];
        for(int k=0;k<tmp_answer.size();k++) answer[k]=tmp_answer.get(k);
        return answer;
    }

}

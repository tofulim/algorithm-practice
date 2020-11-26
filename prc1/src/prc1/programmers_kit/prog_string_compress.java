package prc1.programmers_kit;
import java.io.IOException;
public class prog_string_compress {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println(solution("abcabcdede"));
	}
	/*
	public static int solution(String s) {
		int answer = s.length();
        if(s.length()==1) return 1;
        for(int i=1;i<=s.length()/2;i++) {
        	String iterString=s.substring(0, i);
            String compString="";
        	int start;
        	boolean flag=true;
        	if(s.length()%i!=0) flag=false;
        	int tmp_answer=0;
        	int num=1;
        	int endidx=(s.length()/i)*i;
        	for(start=i;start<endidx;start+=i) {
        		compString=s.substring(start, start+i);
        		if(iterString.equals(compString)) {
        			num++;
        		}
        		else {
        			int level=0;
        			while(Math.pow(10, level)<=num) level++;
        			tmp_answer+=num>1?i+level:i;
        			num=1;
        			iterString=compString;
        		}
        	}
        	int level=0;
            while(Math.pow(10, level)<=num) level++;
            tmp_answer+=num>1?i+level:i;
        	if(!flag) tmp_answer+=s.length()-start;
        	answer=Math.min(tmp_answer, answer);
        }
        return answer;
    }*/
	public static int solution(String s) {
		int answer = s.length();
        if(s.length()==1) return 1;
        for(int i=1;i<=s.length()/2;i++) {
        	StringBuilder ansString = new StringBuilder();
        	String iterString=s.substring(0, i);
            String compString="";
        	int start;
        	boolean flag=true;
        	if(s.length()%i!=0) flag=false;
        	int tmp_answer=0;
        	int num=1;
        	int endidx=(s.length()/i)*i;
        	for(start=i;start<endidx;start+=i) {
        		compString=s.substring(start, start+i);
        		if(iterString.equals(compString)) {
        			num++;
        		}
        		else {
        			if(num>1) ansString.append(num);
        			ansString.append(iterString);
        			num=1;
        			iterString=compString;
        		}
        		System.out.println(ansString);
        	}
            if(num>1) ansString.append(num);
            System.out.println(ansString);
            tmp_answer=ansString.append(compString).length();
            System.out.println(tmp_answer);
        	if(!flag) {
        		tmp_answer+=s.length()-start;
        	}
        	System.out.println(tmp_answer);
        	answer=Math.min(tmp_answer, answer);
        }
        return answer;
    }

}

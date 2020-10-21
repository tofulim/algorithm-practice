package prc1.programmers_kit;
import java.util.*;
public class prog_dfs_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String b="hit";
		String t="cog";
		String[] w= {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(b,t,w));
	}
	static String t;
	static int answer2;
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer2=words.length;
        t=target;
        Boolean[] check=new Boolean[words.length];
        for(int i=0;i<check.length; i++) {
        	check[i]=true;
        }
        if(!Arrays.asList(words).contains(target)) {
        	return 0;
        }
        
        dfs(begin,words,check,0);
        
        return answer2;
    }
	public static void dfs(String nword, String[] words,Boolean[] check, int num) {
		if(nword==t && num<answer2 ) answer2=num;
		for(int i=0;i<check.length;i++) {
			if(check[i]) { //아직 안함
				int change=0;
				for(int j=0;j<nword.length();j++) {
					if(nword.charAt(j)==words[i].charAt(j)) {
						change++;
					}
				}
				if(change==2) {
					check[i]=false;
	//				System.out.println(nword+":"+words[i]+" : "+num);
					dfs(words[i],words,check,num+1);
					check[i]=true;
				}
			}			
		}
		return;
	}
	
}

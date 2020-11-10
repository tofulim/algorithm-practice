package prc1.kakao;
import java.util.HashSet;
public class kakao_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s= {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
			System.out.println(solution(s));
	}
	public static int[] solution(String[] gems) {
		HashSet <String> hs=new HashSet <String>();
        for(int i=0;i<gems.length;i++) {
        	hs.add(gems[i]);
        }
        int num=hs.size(); //총 보석 개수
        int [][] dp = new int[gems.length-num][3]; //시작,끝,길이
        for(int j=0;j<=gems.length-num-1;j++) { //구간 index
        	dp[j][0]=j+1; //시작구간 체크
        	HashSet <String> tmp; //복사
        	tmp=(HashSet<String>) hs.clone();
        	for(int k=j;k<gems.length;k++) {
        		if(!tmp.isEmpty()) {
        			tmp.remove(gems[k]);
        			dp[j][1]=k+1; //끝난 지점 기록
        			if(tmp.isEmpty()) { //비었다 == 끝났다		
        				dp[j][2]=1;
        				break;
        			}
        		}
        	}
        }
        int minlen=dp[0][1]-dp[0][0];
        int minlenidx=-1;
        for(int i=0;i<gems.length-num;i++) {
        	if(dp[i][1]-dp[i][0]<=minlen && dp[i][2]==1) {
        		minlen=dp[i][1]-dp[i][0];
        		if(minlenidx!=-1) {
	        		if(dp[minlenidx][1]-dp[minlenidx][0]>dp[i][1]-dp[i][0] && dp[minlenidx][1]-dp[minlenidx][0] >=minlen) {
	        			minlenidx=i;
	        		}
        		}
        		else {
        			minlenidx=i;
        		}
        		
        	}
        }
        
		int[] answer = new int[2]; //1더해서 넣어야함
		answer[0]=dp[minlenidx][0];
		answer[1]=dp[minlenidx][1];
        
        return answer;	
	}

}

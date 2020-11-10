package prc1.kakao;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class kakao_불량사용자 {
    static int answer = 0;
    static  ArrayList <ArrayList> list; 
    
	public static int solution(String[] user_id, String[] banned_id) {
        boolean [] visited=new boolean[user_id.length]; 
        list = new ArrayList<>();	
        dfs(user_id,banned_id,0,0,visited);
        return answer;
    }
    public static void dfs(String[] user_id, String [] banned_id, int idx, int n ,boolean[] visited) {

    	if(n==banned_id.length) {
    		ArrayList<Integer> tmp = new ArrayList<>();
    		for(int i=0;i<visited.length;i++) {
    			if(visited[i]) tmp.add(i);
    		}
    		
    		int cnt=0;
    		for(int i=0;i<list.size();i++) {
    			boolean flag=true;
    			ArrayList<Integer> t=list.get(i);
    			for(int j=0;j<t.size();j++) {
    				if(!t.contains(tmp.get(j))){
    					flag=false;
    				}
    			}
    			if(!flag) cnt++;
    			
    		}
    		if(cnt==list.size()) {list.add(tmp); answer++;}
    		return ;
    	}
    	for(int i=0;i<user_id.length;i++) {
    		String s= banned_id[idx].replace("*","[\\w]");
    		Pattern pattern=Pattern.compile(s);
    		Matcher matcher=pattern.matcher(user_id[i]);
    		
    		if(matcher.find() && banned_id[idx].length()==user_id[i].length()) {
    			if(!visited[i]) {
    				visited[i]=true;
    				dfs(user_id,banned_id,idx+1,n+1,visited);
    				visited[i]=false;
    			}
    		}
    	}
    	
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String[] user_id= {"frodo", "fradi", "crodo", "abc123", "frodoc"};
    	String[] banned_id= {"fr*d*", "abc1**"};
    	System.out.println(solution(user_id,banned_id));
	}
}
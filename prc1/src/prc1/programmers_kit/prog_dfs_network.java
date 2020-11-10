package prc1.programmers_kit;
import java.sql.Array;
import java.util.*;

public class prog_dfs_network {
	static boolean[] visit;
	static int answer;
	public static int solution(int n, int[][] computers) {
        answer = 0;
        visit=new boolean[n];
        Arrays.fill(visit, false);
        for(int i=0;i<n;i++) {
        	if(visit[i]) continue;
        	dfs(visit, computers,i);
    		answer++;
        }
        System.out.println(answer);
        System.out.println(Arrays.toString(visit));
        return answer;
    }
	
	public static void dfs(boolean[] visit, int[][] computers,int idx ) {
		visit[idx]=true;
		for(int j=0;j<visit.length;j++) {
			if(j==idx) continue; //nxn번째 자기자신 생략
			else if(computers[idx][j]==1 && !visit[j]) {
				dfs(visit,computers,j);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		solution(3,arr);
	}

	
}

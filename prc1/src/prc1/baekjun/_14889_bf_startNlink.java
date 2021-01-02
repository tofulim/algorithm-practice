package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _14889_bf_startNlink {
	static int n,answer;
	static int [][] people;
	static boolean [] visit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		people = new int[n][n];
		visit = new boolean[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) people[i][j]=Integer.parseInt(st.nextToken());
		}
		answer=Integer.MAX_VALUE;
		makeTeam(0,0);
		
		System.out.println(answer);
	}
	public static void makeTeam(int start, int num) {
		if(num==n/2) {
			diff();
			return;
		}
		else {
			for(int i=start;i<n;i++) {
				if(!visit[i]) {
					visit[i]=true;
					makeTeam(i,num+1);
					visit[i]=false;
				}
			}
		}
	}
	public static void diff() {
		int s_score=0;
		int l_score=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(visit[i] && visit[j]) s_score+=people[i][j]+people[j][i];
				else if(!visit[i] && !visit[j]) l_score+=people[i][j]+people[j][i];
			}
		}
		answer=Math.min(answer, Math.abs(s_score-l_score));
	}

}

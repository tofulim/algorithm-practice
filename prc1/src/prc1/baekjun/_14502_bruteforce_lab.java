package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _14502_bruteforce_lab {
	static boolean [][] visit;
	static int [][]arr;
	static int answer;
	static int tmp_answer=0;
	static int [] x= {0,1,0,-1};
	static int [] y = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		visit=new boolean[n][m];
		boolean [][]col_visit= new boolean[n][m];
		for(boolean a[]:col_visit) Arrays.fill(a, false);
		for(boolean a[]:visit) Arrays.fill(a, false);
		arr=new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		answer=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					columnMaker(i,j,1,col_visit);
					arr[i][j]=0; col_visit[i][j]=false;
				}
			}
		}
		System.out.println(answer);

	}
	public static void columnMaker(int i, int j,int num,boolean [][] col_visit) {
		col_visit[i][j]=true;
		arr[i][j]=1;  //기둥 세우기
		
		if(num==3) { //3일때 break
			get_Score();
		}
		else {
			for(int k=i;k<arr.length;k++) {
				for(int kk=0;kk<arr[0].length;kk++) {
					if(arr[k][kk]==0 && !col_visit[k][kk]) { //0이고 기둥이 세워진 적 없을 때
						columnMaker(k,kk,num+1,col_visit);
						arr[k][kk]=0;
						col_visit[k][kk]=false;
					}
				}
			}	
		}
	}
	
	public static void get_Score() {
		for(boolean a[]:visit) Arrays.fill(a, false); //방문 배열도 초기화해줌
		tmp_answer=0;
		int tmp_arr[][] = new int[arr.length][arr[0].length];
	    
        for(int i=0;i<arr.length;i++) { //배열의 복사
        	for(int j=0;j<arr[0].length;j++) {
        		tmp_arr[i][j]=arr[i][j];
        	}
        }
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(tmp_arr[i][j]==2 && visit[i][j]==false) { //감염을 시작할 2를 찾기
					visit[i][j]=true;
					dfs(i,j,tmp_arr);
				}
			}
		}
		for(int i=0;i<arr.length;i++) { //안전구역 찾기
			for(int j=0;j<arr[0].length;j++) {
				if(tmp_arr[i][j]==0) tmp_answer++;
			}
		}
		answer=answer>tmp_answer?answer:tmp_answer;
	}
	public static void dfs(int i,int j,int [][] tmp_arr) {
		for(int k=0;k<4;k++) {
			int newx=j+x[k];
			int newy=i+y[k];
			if(newx>=0 && newx<arr[0].length && newy>=0 && newy<arr.length) { //범위를 벗어나는지 확인
				if(tmp_arr[newy][newx]==0) { //감염시킬 조건
					visit[newy][newx]=true;
					tmp_arr[newy][newx]=2; //감염
					dfs(newy,newx,tmp_arr); //다음으로 옮겨 감염준비
				}
			}// 2로 바꾼걸 다시 0으로 바꿔야함
		}
	}

}

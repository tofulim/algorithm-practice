package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _14503_graph_robot_cleaner {
	static boolean [][] visit;
	static int clean_area=0;
	static int []x= {-1,0,1,0}; //북동남서 순서임
	static int []y= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[] robot_location=new int[2];
		st = new StringTokenizer(br.readLine());
		robot_location[0]=Integer.parseInt(st.nextToken());
		robot_location[1]=Integer.parseInt(st.nextToken());
		int head=Integer.parseInt(st.nextToken());
		int [][]arr=new int[n][m];
		visit=new boolean[n][m];
		for(boolean[] v:visit) Arrays.fill(v,false);
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		visit[robot_location[0]][robot_location[1]]=true;
		clean_area++;
		go_Clean(robot_location[0],robot_location[1],head,arr);
		System.out.println(clean_area);
	}
	public static void go_Clean(int i,int j, int head,int[][] arr) {
		int newx=j+x[head];
		int newy=i+y[head];
		
		boolean flag=true;; //2-c & d 확인용
		for(int k=0;k<4;k++) { //동서남북 다 안되는지 확인
			int xx=j+x[k];
			int yy=i+y[k];
			if(arr[yy][xx]==0 && !visit[yy][xx]) flag=false; //되는게 하나 있음
		}
		if(flag) { //되는게 하나도 없을 때 c와 d를 실행시켜야함
			int xx=j;
			int yy=i;
			if(head==0) yy+=1;
			else if(head==1) xx-=1;
			else if(head==2) yy-=1;
			else xx+=1;
			if(arr[yy][xx]==1 )return; //d일때
			else { //c일때
				go_Clean(yy,xx,head,arr);
			}
		}
		else if(arr[newy][newx]==0 && !visit[newy][newx]) {//왼쪽에 있을 때
			clean_area++;
			visit[newy][newx]=true;
			head=head==0?3:head-1;
			go_Clean(newy,newx,head,arr);
		}
		else if(arr[newy][newx]==1 || visit[newy][newx]) {//벽이거나 이미 방문함
			head=head==0?3:head-1;
			go_Clean(i,j,head,arr); //방향만 틀어줌
		}
	}

}

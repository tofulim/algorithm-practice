package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _3190_implement_snake {

	static int snake_direction[]= {0,1,2,3}; //동서남북
	static int direction[][]= {{0,1},{0,-1},{1,0},{-1,0}}; //동서남북
	static int [][]arr;
	static int dir_change_num;
	static int [] dir_change_time;
	static String [] dir_change_direction;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int apple_num =Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int [] a : arr) Arrays.fill(a, 0);
		
		for(int i=0;i<apple_num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		
		dir_change_num =Integer.parseInt(br.readLine());
		dir_change_time=new int[dir_change_num];
		dir_change_direction=new String[dir_change_num];
		
		for(int j=0;j<dir_change_num;j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir_change_time[j]=Integer.parseInt(st.nextToken());
			dir_change_direction[j]=st.nextToken();
		}
		go_snake(0,0);

	}
	public static void go_snake(int y,int x ) {
		ArrayList <Snake> al=new ArrayList<>();
		al.add(new Snake(0,0));
		int time=0;
		int now_direction=0;
		int turntime=0;
		while(true) {
			if(dir_change_time[turntime]==time) { //현재 시간이 방향 틀 시간인가?
				if(turntime<dir_change_time.length-1) {
					now_direction=direction_Changer(now_direction,dir_change_direction[turntime++]);
				}
				else now_direction=direction_Changer(now_direction,dir_change_direction[turntime]);
			}
			x+=direction[now_direction][1];
			y+=direction[now_direction][0];
			Snake s = new Snake(y,x);
			if(x< 0|| x>arr[0].length-1 || y<0 || y>arr.length-1) { //몸통이나 벽을 만났음
				System.out.println(++time);
				return;
			}
			else {
				for(int i=0;i<al.size();i++) {
					if(al.get(i).x==x && al.get(i).y==y) {
						System.out.println(++time);
						return;
					}
				}
			}
			al.add(s);
			if(arr[y][x]==0) {
				al.remove(0);
			}
			else arr[y][x]=0;
			time++;
		}
	}
	public static int direction_Changer(int now_direction, String changeto) {
		if(now_direction==0) { //동쪽일때
			return changeto.equals("L")?3:2;
		}
		else if(now_direction==1) { //서
			return changeto.equals("L")?2:3;
		}
		else if(now_direction==2) {  //남
			return changeto.equals("L")?0:1;
		}
		else if(now_direction==3) { //북
			return changeto.equals("L")?1:0;	
		}
		else return now_direction;
	}
	public static class Snake{
		int x,y;
		public Snake(int y, int x) {
			this.x=x;
			this.y=y;
		}
	}

}

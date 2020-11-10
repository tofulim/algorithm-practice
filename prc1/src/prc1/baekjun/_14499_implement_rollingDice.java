package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _14499_implement_rollingDice {
	static int [][] arr;
	static int [] dice_state={0,0,0,0,0,0};
	static int [][] move= {{0,1},{0,-1},{-1,0},{1,0}};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		int move_number= Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int k=0;k<move_number;k++) {
			int move_direction=Integer.parseInt(st.nextToken());
			if(x+move[move_direction-1][1]<0 || x+move[move_direction-1][1]>m-1 || y+move[move_direction-1][0]<0 || y+move[move_direction-1][0]>n-1) continue;
			x+=move[move_direction-1][1]; //경계값 확인 후 현재 주사위의 좌표 수정
			y+=move[move_direction-1][0];
			change_diceState(move_direction); //주사위 굴리기
			
			if(arr[y][x]==0)  arr[y][x]=dice_state[1]; //바닥면과 비교
			else {
				dice_state[1]=arr[y][x];
				arr[y][x]=0;
			}	
		}

	}
	public static void change_diceState(int i) { 
		int [] tmp_dice = dice_state.clone();
		if(i==1) {
			dice_state[0]=tmp_dice[2];
			dice_state[1]=tmp_dice[3];
			dice_state[3]=tmp_dice[0];
			dice_state[2]=tmp_dice[1];
		}
		else if(i==2) {
			dice_state[0]=tmp_dice[3];
			dice_state[1]=tmp_dice[2];
			dice_state[2]=tmp_dice[0];
			dice_state[3]=tmp_dice[1];
		}
		else if(i==3) {
			dice_state[0]=tmp_dice[5];
			dice_state[1]=tmp_dice[4];
			dice_state[4]=tmp_dice[0];
			dice_state[5]=tmp_dice[1];
		}
		else if(i==4) {
			dice_state[0]=tmp_dice[4];
			dice_state[1]=tmp_dice[5];
			dice_state[4]=tmp_dice[1];
			dice_state[5]=tmp_dice[0];
		}
		System.out.println(dice_state[0]);
	}

}

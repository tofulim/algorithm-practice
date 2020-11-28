package prc1.programmers_kit;

import java.util.Arrays;

public class prog_math_quadCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]arr= {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		System.out.println(Arrays.toString(solution(arr)));
	}
	static int [][] tmp_arr;
	public static int[] solution(int[][] arr) {
        tmp_arr=arr;
        int len=arr[0].length;
        int answer[]=new int[2];
        return quadCompress(0,len-1,0,len-1);
    }
	public static int[] quadCompress(int y_start,int y_end,int x_start,int x_end) {
		int zeroone[]= {0,0};
		System.out.println(y_start+":"+y_end+":"+x_start+":"+x_end);
		if(y_start==y_end && x_start==x_end) {
			if(tmp_arr[y_start][x_start]==0) zeroone[0]=1;
			else zeroone[1]=1;
			return zeroone;
		}
		if(y_start>y_end || x_start>x_end) return zeroone;
		int len=y_end-y_start+1;
		int ymid=(y_start+y_end)/2;
		int xmid=(x_start+x_end)/2;
		int zeroone1[]=quadCompress(y_start,ymid,x_start,xmid);
		int zeroone2[]=quadCompress(y_start,ymid,xmid+1,x_end);
		int zeroone3[]=quadCompress(ymid+1,y_end,x_start,xmid);
		int zeroone4[]=quadCompress(ymid+1,y_end,xmid+1,x_end);
		zeroone[0]=zeroone1[0]+zeroone2[0]+zeroone3[0]+zeroone4[0];
		zeroone[1]=zeroone1[1]+zeroone2[1]+zeroone3[1]+zeroone4[1];
		if(zeroone[0]==4 && zeroone[1]==0) zeroone[0]=1;
		else if(zeroone[1]==4 && zeroone[0]==0) zeroone[1]=1;
		return zeroone;
	}

}

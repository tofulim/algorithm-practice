package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _14888_bf_operatorInsert {

	static int n,m;
	static int [] num_arr; //숫자 배열
	static int [] op_arr; // 연산자 배열
	static int min,max;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num_arr = new int[n];
		for(int i=0;i<n;i++) num_arr[i]=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		op_arr=new int[4];
		for(int i=0;i<4;i++) {
			op_arr[i]=Integer.parseInt(st.nextToken());
		}
		
		min=1000000000;
		max=-min;
		
		makeCombination(1,num_arr[0],0);
		System.out.print(max+"\n"+min);
	}
	public static void makeCombination(int start, int result,int num) {
		if(num==n-1) {
			min=Math.min(min, result);
			max=Math.max(max, result);
		}
		else {
			for(int i=0;i<4;i++) {
				if(op_arr[i]!=0) {
					op_arr[i]--;
					int res=doOperation(num_arr[start],result,i);
					makeCombination(start+1,res,num+1);
					op_arr[i]++;
				}
			}
		}
	}
	public static int doOperation(int right,int left, int idx) {
		switch(idx) {
			case 0:{
				return left+right;
			}
			case 1:{
				return left-right;
			}
			case 2:{
				return left*right;
			}
			case 3:{
				return left/right;
			}
			default:
				return left;
		}
	}

}

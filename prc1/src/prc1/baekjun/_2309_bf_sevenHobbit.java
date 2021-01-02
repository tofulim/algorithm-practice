package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class _2309_bf_sevenHobbit {

	static int [] hobbit;
	static boolean [] check;
	static int [] real_hobbit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		hobbit=new int[9];
		check = new boolean[9];
		for(int i=0;i<9;i++) hobbit[i]=Integer.parseInt(br.readLine());
		
		real_hobbit=new int[7];
		height_check(0,0,0);
		
		StringBuilder sb = new StringBuilder();
		Arrays.sort(real_hobbit);
		for(int i=0;i<7;i++) sb.append(real_hobbit[i]+"\n");
		System.out.print(sb.toString());
		
	}
	
	public static void height_check(int start, int sum, int hob_num) {
		if(hob_num==7 && sum==100) {
			int idx=0;
			for(int i=0;i<9;i++) {
				if(check[i]) {
					real_hobbit[idx++]=hobbit[i];
				}
			}
		}
		else {
			for(int i=start;i<9;i++) {
				if(!check[i] && sum+hobbit[i]<=100) {
					check[i]=true;
					height_check(i,sum+hobbit[i],hob_num+1);
					check[i]=false;
				}
			}
		}
	}

}

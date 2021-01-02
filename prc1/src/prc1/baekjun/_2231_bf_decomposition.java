package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _2231_bf_decomposition {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		int constructor=1;
		int sum=0;
		while(sum!=num) {
			if(constructor>=num) {
				System.out.println(0);
				return;
			}
			sum=0;
			int level=0;
			int tmp=constructor;
			
			while(Math.pow(10, level)<=constructor) level++;

			while(tmp!=0) {
				int idx_num=tmp/(int)Math.pow(10, level);
				sum+=idx_num;
				tmp-=idx_num*(int)Math.pow(10, level);
				level--;
			}
			sum+=constructor;
			constructor++;
		}
		
		System.out.println(constructor-1);
	}

}
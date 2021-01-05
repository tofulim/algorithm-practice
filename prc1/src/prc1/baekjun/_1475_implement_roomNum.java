package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1475_implement_roomNum {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int answer=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char [] num_arr= new char[10];
		for(int i=0;i<s.length();i++) {
			answer+=getNum(s.charAt(i),num_arr);
		}
		System.out.println(answer);

	}
	public static int getNum(char num,char [] num_arr) {
		int int_num=num-48;
		
		if(num_arr[int_num]!=0) {
			num_arr[int_num]--;
			return 0;
		}
		else if(int_num==9 && num_arr[6]!=0|| int_num==6 && num_arr[9]!=0) {
			if(int_num==9 && num_arr[6]!=0) num_arr[6]--;
			else if(int_num==6 && num_arr[9]!=0) num_arr[9]--;
			return 0;
		}
		else {
			for(int i=0;i<10;i++) num_arr[i]++;
			num_arr[int_num]--;
			return 1;
		}
	}

}

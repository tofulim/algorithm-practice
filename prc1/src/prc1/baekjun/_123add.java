package prc1.baekjun; //9095번 123더하기
import java.util.Scanner;


public class _123add {
	static int cnt=0;
	static void cycle(int x) {
		if(x>3) {
			cycle(x-1);
			cycle(x-2);
			cycle(x-3);
		}
		else if(x<=3) {
			if(x==3) {cnt=cnt+4; return;}
			else if(x==2) {cnt=cnt+2; return;}
			else if(x==1) {cnt=cnt+1; return;}
		}	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			cnt=0;
			int num=sc.nextInt();
			cycle(num); 
			System.out.println(cnt);
		}
	}

}

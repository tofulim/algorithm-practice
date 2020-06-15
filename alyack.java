package prc1;
import java.util.Scanner;

class alyack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			cnt=0;
			n=sc.nextInt();
			if(n==0) break;
			cycle(n,0);
			System.out.println(cnt);
		}
		sc.close();
	}
	static long cnt;
	static void cycle(int W,int H) {
		if(W==0) {cnt++;return;} //끝자리까지 갔을 때
		if(H==0) {cycle(W-1,H+1);}
		else {
			cycle(W-1,H+1);
			cycle(W,H-1);
		}
	}
}

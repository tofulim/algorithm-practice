package prc1;
import java.util.Scanner;

public class sopung2 {
	static int K;
	static int cnt=0;//������� ����
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		K=sc.nextInt();
		int M=sc.nextInt();
		cycle(N,M);
		sc.close();
		return ;
	}
	static void cycle(int n,int m) { //��ȣ�� ������ϸ� �ٷ� ����
		int out=K%n; //����� �ε���
		if(out==0) out=n;
		if(out==m) {System.out.print(++cnt); return;} //��ȣ ����
		if(out>m) m=n+m-out;
		else {m=m-out;} 
		n--;cnt++;
		cycle(n,m);		
	}
}

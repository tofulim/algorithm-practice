package prc1.baekjun;
import java.util.Scanner;
public class theaterSeat2302 {
	static long fb(int n) {
		  int i;
		  int one = 1 , two = 2, result = -1;  // one�� n-2, two��n-1 �� 
		 
		  if(n==1||n==0)  // 1 �Ǵ� 2�� 1�� ������
		    return 1;
		  else if(n==2)
			return 2;
		  else {
		    for(i=3; i<=n; i++) {
		      result = one + two;   // ����(n-1)�� ������(n-2) ���� ���ؼ� ������ 
		      one = two;      // ������(n-2) = ����(n-1)
		      two = result;     // ����(n-1) = ���簪(now)  
		    }   
		  }  
		  return result; 
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int num=sc.nextInt();
		int sum=1;
		int c2=0;
		for(int j=0;j<num;j++) {
			int c=sc.nextInt();
			sum*=fb(c-c2-1);
			c2=c;
		}
		System.out.println(sum*=fb(N-c2));
	}

}

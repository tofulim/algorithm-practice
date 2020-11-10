package prc1.baekjun;
import java.util.Scanner;
public class getbridge1010 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		long result1; long result2;
		for(int i=0;i<tc;i++) {
			result1=1;result2=1;
			int l=sc.nextInt();
			int r=sc.nextInt();
			for(int k=r-l;k>0;k--) {
				result1*=r--;
				result2*=k;
				if(result1%result2==0) {
					result1=result1/result2;
					result2=1;
				}
			
			}
			System.out.println(result1/result2);
		}
	}

}

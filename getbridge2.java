package prc1;
import java.util.Scanner;
import java.math.BigInteger;
public class getbridge2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		for(int i=0;i<tc;i++) {
			int l=sc.nextInt();
			int r=sc.nextInt();
			BigInteger sum=new BigInteger("1");
			BigInteger div=new BigInteger("1");
			for(int k=r-l;k>0;k--) {
				sum=sum.multiply(BigInteger.valueOf(r--));
				div=div.multiply(BigInteger.valueOf(k));
			}
			System.out.println(sum.divide(div));
		}
	}

}

package prc1;
import java.util.Scanner;
import java.math.BigInteger;

public class _2xnTiling2_11727 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int c=n/2;
		BigInteger sum1=new BigInteger("1");
		if(c<1) {System.out.println(1); return;}
		else {
			
			for(int m=c;m>0;m--) {
				int kk=n-m;
				BigInteger sum=new BigInteger("1");
				BigInteger div=new BigInteger("1");
				BigInteger mm=new BigInteger("10007");
				long tmp=(long)Math.pow(2, m);
				for(int k=m;k>0;k--) {
					sum=sum.multiply(BigInteger.valueOf(kk--));
					div=div.multiply(BigInteger.valueOf(k));
				}
				sum=sum.multiply(BigInteger.valueOf(tmp));
				sum1=sum1.add(sum.divide(div));
				sum1=sum1.mod(mm);
			}
			System.out.println(sum1);
		}
	}

}

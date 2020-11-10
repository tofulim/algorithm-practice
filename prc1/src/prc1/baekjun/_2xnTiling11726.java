package prc1.baekjun;
import java.util.Scanner;
import java.math.BigInteger;

public class _2xnTiling11726 {

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
				for(int k=m;k>0;k--) {
					sum=sum.multiply(BigInteger.valueOf(kk--));
					div=div.multiply(BigInteger.valueOf(k));
				}
				sum1=sum1.add(sum.divide(div));
			}
			BigInteger mm=new BigInteger("10007");
			sum1=sum1.mod(mm);
			System.out.println(sum1);
		}
	}

}

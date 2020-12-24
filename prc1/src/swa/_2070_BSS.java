package swa;
import java.util.Scanner;

class _2070_BSS
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
			int m = sc.nextInt();
            System.out.println("#"+test_case+" "+(n>m?">":n==m?"=":"<"));
		}
	}
}
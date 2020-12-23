package swa;

import java.util.Scanner;
import java.io.FileInputStream;

class _2071_getAvg
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sum=0;
            for(int i=0;i<10;i++) sum+=sc.nextInt();
            System.out.println("#"+test_case+" "+Math.round(sum/(double)10));
		}
	}
}
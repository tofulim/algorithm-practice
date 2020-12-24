package swa;

import java.util.Scanner;

public class _1926_simple369 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String num=test_case+"";
            boolean flag=true;
            for(int i=0;i<num.length();i++){
                char tmp=num.charAt(i);
             	if(tmp!='0' && (tmp-48)%3==0) {
                    sb.append("-");   
                    flag=false;
                }
            }
            if(flag) sb.append(num+" ");
            else sb.append(" ");
		}
        System.out.print(sb.toString());
	}
}
package swa;
import java.io.*;
import java.util.*;

public class _2007_paternlen {

	public static void main(String args[]) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = br.readLine();
            int answer=0;
            for(int i=1;i<=10;i++){
             	
                String checker=s.substring(0,i);
                boolean flag=true;
                int start=i;
                int end=i*2;
                while(end<=30){
                 	if(!checker.equals(s.substring(start,end))) {
                        flag=false;
                        break;
                    }
                 	start+=i;
                    end+=i;
                }
                if(flag) {
                    answer=i;
                    break;
                }
            }
			System.out.println("#"+test_case+" "+answer);
		}
	}
}
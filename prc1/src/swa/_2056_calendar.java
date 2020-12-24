package swa;
import java.util.*;
import java.io.*;

public class _2056_calendar {

	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = br.readLine();
            String y=s.substring(0,4);
			int year = Integer.parseInt(y);
            String m=s.substring(4,6);
            int month=Integer.parseInt(m);
            String d=s.substring(6);
            int day=Integer.parseInt(d);
            if(year==0) {
             	System.out.println("#"+test_case+" "+-1);
                continue;
            }
            if(month<1 || month>12) {
             	 System.out.println("#"+test_case+" "+-1);
                continue;  
            }
            if(month==2 && day>28) {
             	 System.out.println("#"+test_case+" "+-1);
                continue;     
            }
            if(month == 4 || month == 6 || month == 9 || month == 10 && day>30){
             	  System.out.println("#"+test_case+" "+-1);
                continue;   
            }
            if(day>31) {
            	  System.out.println("#"+test_case+" "+-1);
                continue;      
            }
            System.out.println("#"+test_case+" "+y+"/"+m+"/"+d);
            
		}
	}
}

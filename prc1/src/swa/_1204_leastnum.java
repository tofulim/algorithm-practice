package swa;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.util.Map.Entry;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int tc=sc.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer,Integer>(); 
            int num=0;
			for(int i=0;i<1000;i++) {
             	num =sc.nextInt();   
                map.put(num, map.getOrDefault(num,0)+1);
            }
            ArrayList <Entry <Integer,Integer>> al = new ArrayList<Entry <Integer,Integer>>(map.entrySet());
            Collections.sort(al, new Comparator<Entry<Integer,Integer>>(){
                @Override
                public int compare(Entry<Integer,Integer> e1, Entry<Integer,Integer> e2){
                	    int e1_val=e1.getValue();
                    	int e2_val=e2.getValue();
                        if(e1_val==e2_val) {
                            return e2.getKey()-e1.getKey();
                        }
                    	else return e2.getValue()-e1.getValue();
                }
            });
            System.out.println("#"+test_case+" "+al.get(0).getKey());
		}
	}
}
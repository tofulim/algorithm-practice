package prc1.programmers_kit;

import java.util.Arrays;

public class prog_string_bitranse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1111111";
		System.out.println(Arrays.toString(solution(s)));
	}
	static int zerosum=0;
	public static int[] solution(String s) {
        
        int num=1;
        StringBuilder sb = new StringBuilder(s);
        while((sb=biTranse(sb)).length()!=1) num++;
        int[] answer = {num,zerosum};
        return answer;
    }
	public static StringBuilder biTranse(StringBuilder sb) {
		int zeronum=0;
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)=='0') zeronum++;
		}
		StringBuilder ns=new StringBuilder ();
		int len=sb.length()-zeronum;
		System.out.println("len"+len);
		zerosum+=zeronum;
		while(len>0) {
			ns.append(len%2);
			len/=2;
		}
		return ns;
		
	}

}

package prc1.programmers_kit;

public class prog_greedy_makeBigNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("99999999",7));
	}
	public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int iterK=0;
        int iter=0;
        int len=sb.length();
        while(k!=iterK && iter<len-1) {
        	if(sb.charAt(iter)<sb.charAt(iter+1)){
        		sb.deleteCharAt(iter);
        		iterK++;
        		iter=0;
        		len--;
        	}
        	else iter++;
        }
        if(k!=iterK) sb.delete(len-(k-iterK), len);
        return sb.toString();
    }

}
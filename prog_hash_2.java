package prc1.programmers_kit;
import java.util.Arrays;
public class prog_hash_2 {
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        System.out.println(phone_book[0]);
        System.out.println(phone_book[1]);
        System.out.println(phone_book[2]);
        for(int i=0;i<phone_book.length-1;i++) {
        	int son=phone_book[i].length();
        	for(int j=i+1;j<phone_book.length;j++) {
        		if(phone_book[j].indexOf(phone_book[i])==0) {
        			return false;
        		}
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] p= {"11130", "1113","222444", "222"};
		System.out.println(solution(p));

	}

}

package prc1.programmers_kit;
import java.util.Arrays;

public class prog_hash_cannotdidPerson {
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        System.out.println(Arrays.toString(participant));
        Arrays.sort(completion);
        System.out.println(Arrays.toString(completion));
        for(int i=0;i<participant.length;i++) {
        	if(i==participant.length-1) answer=participant[i];
        	else if(!participant[i].equals(completion[i])) {
        		answer=participant[i];
        		break;
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		String [] p = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String [] c = {"josipa", "filipa", "marina", "nikola"};
		int [] a = {1,2,3};
		int [] b= {1,2,3,4};
		int cc=4;
		int d=4;
		String aa="asd";
		String bb="asd";
		String ccc=new String("asd");
		
		System.out.println(System.identityHashCode(aa)+" : "+System.identityHashCode(bb)+" : "+System.identityHashCode(ccc));
		
		boolean tmp=a[1]==b[1]?true:false;
		boolean tmp2=cc==d?true:false;
		
		System.out.println(tmp+":"+tmp2);
				
		System.out.println(solution(p,c));
		
	}
	

}

//class Solution {
//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        for(int i=0;i<participant.length;i++) {
//        	if(participant[i]!=completion[i]) {
//        		answer=participant[i];
//        		break;
//        	}
//        }
//        return answer;
//    }
//}
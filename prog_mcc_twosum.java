package prc1.programmers_kit;
import java.util.*;

public class prog_mcc_twosum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numbers= {2,1,3,4,1};
		solution(numbers);
	}
	public static Integer[] solution(int[] numbers) {
        Integer [] answer;
        int num=0;
        HashSet<Integer> hs = new HashSet<Integer>();
       
        for(int i=0;i<numbers.length-1;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		num=numbers[i]+numbers[j];
        		hs.add(num);
        	}
        }
        List <Integer> arr=new ArrayList(hs);
        Collections.sort(arr);
        answer=arr.toArray(new Integer[arr.size()]);
        System.out.println(arr.toString());
        return answer;
    }
}

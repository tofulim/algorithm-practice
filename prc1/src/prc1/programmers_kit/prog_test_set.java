package prc1.programmers_kit;

import java.util.ArrayList;
import java.util.Arrays;

public class prog_test_set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,1,3,3,0,1,1};
		System.out.println(Arrays.toString(solution(arr)));
	}
	public static int[] solution(int []arr) {
		int len=arr.length;
		ArrayList<Integer> answer=new ArrayList<Integer>();
        if(len>=1) answer.add(arr[0]);
        if(len>=2) {
        	for(int i=0;i<len-1;i++){
                if(arr[i]!=arr[i+1]) answer.add(arr[i+1]);  
            }
        }
        
        
        int answer_i [] = new int[answer.size()];
        for(int i=0;i<answer.size();i++) answer_i[i]=answer.get(i); 
        return answer_i;
    }

}

package prc1.programmers_kit;
import java.util.Arrays;

public class prog_test_ridMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {4,3,2,1};
		System.out.println(Arrays.toString(solution1(arr)));
		System.out.println(Arrays.toString(solution2(arr)));
	}
	public static int[] solution1(int[] arr) {
        int [] answer2={-1};
        if(arr.length==1) return answer2;
        int min=1000000000;
        int idx=0;
        for(int i=0;i<arr.length;i++) {
            min=Math.min(min,arr[i]);
        }
        
        int[] answer = new int[arr.length-1];
        for(int j=0;j<arr.length;j++){
            if(arr[j]==min) continue;
            else answer[idx++]=arr[j];
        }
        return answer;
    }
	public static int[] solution2(int[] arr) {
	      if (arr.length <= 1) return new int[]{ -1 };
	      int min = Arrays.stream(arr).min().getAsInt();
	      return Arrays.stream(arr).filter(i -> i != min).toArray();
	  }

}

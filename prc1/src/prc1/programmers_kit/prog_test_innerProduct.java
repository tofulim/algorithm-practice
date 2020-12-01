package prc1.programmers_kit;
import java.util.stream.*;
public class prog_test_innerProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a= {1,2,3,4};
		int []b= {3,-1,0,1};
				
		solution1(a,b);
		solution2(a,b);
	}
	public static int solution1(int[] a, int[] b) {
        int answer=0;
        for(int i=0;i<a.length;i++) answer+=a[i]*b[i];
        return answer;
    }
	public static int solution2(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }

}


package prc1.programmers_kit;
import java.util.*;
public class prog_hash_disguide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] d = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solution(d);
	}
    public static int solution(String[][] clothes) {
        int answer = 1;
        Arrays.sort(clothes, new Comparator<String[]>(){
        	@Override
        	public int compare(String[] o1, String[] o2) {
        		if( o1[1].compareTo(o2[1]) < 0 )
                    return 1;
                else
                    return -1;
            }
        });
        System.out.println(Arrays.toString(clothes[0]));
        System.out.println(Arrays.toString(clothes[1]));
        System.out.println(Arrays.toString(clothes[2]));
        int cnt=1;
        for(int i=0;i<clothes.length-1;i++) {
        	if(clothes[i][1].equals(clothes[i+1][1])) {
        		cnt++;
        	}
        	else {
        		answer*=cnt+1;
        		cnt=1;
        		
        	}
        }
        answer*=cnt+1;
        System.out.println(answer-1);
        return answer-1;
    }


}

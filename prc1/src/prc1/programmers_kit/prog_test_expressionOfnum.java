package prc1.programmers_kit;

public class prog_test_expressionOfnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt("12"));
		System.out.println(solution(15));
	}
	public static int solution(int n) { //그냥 풀이
        int answer = 0;
        for(int i=1;i<n;i++) {
        	int sum=i;
        	for(int j=i+1;j<=n;j++) {
        		sum+=j;
        		if(sum==n) {
        			answer+=1;
        			break; 
        		}
        		else if(sum>n) break;
        	}
        }
        return answer+1;
    }
}

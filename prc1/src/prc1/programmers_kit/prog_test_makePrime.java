package prc1.programmers_kit;

import java.util.Arrays;

public class prog_test_makePrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(5));
	}
	public static int solution(int n) {
        return eratosteneth(n);
    }
	public static int eratosteneth(int n) {
		int level=1;
		boolean [] era= new boolean[n+1];
		Arrays.fill(era, true);
		while(Math.pow(level, 2)<n) level++;
		for(int i=2;i<level;i++) {
			if(!era[i]) continue;
			for(int j=2;i*j<=n;j++) {
				era[i*j]=false;
			}
		}
		int answer=0;
		for(int k=2;k<=n;k++) if(era[k]) answer+=1;
		return answer;
	}

}

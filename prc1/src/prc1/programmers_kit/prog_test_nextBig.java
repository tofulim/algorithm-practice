package prc1.programmers_kit;

public class prog_test_nextBig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(78));
	}
	public static int solution(int n) {
        int start = changeNcount(n);
        while(changeNcount(++n)!=start) ;
        return n;
    }
	public static int changeNcount(int m) {
		int cnt=0;
		while(m!=0) {
			if(m%2==1) cnt++;
			m/=2;
		}
		System.out.println(cnt);
		return cnt;
	}

}

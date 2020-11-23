package prc1.programmers_kit;

public class prog_math_goodRect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    solution(8,12);
	}
	public static long solution(int w, int h) {
        long answer = 0;
        for(int i=1;i<=w-1;i++){
            double tmp=(-(h/(double)w)*i)+h;
            answer+=(int)tmp;
        }
        return 2*answer;
    }

}

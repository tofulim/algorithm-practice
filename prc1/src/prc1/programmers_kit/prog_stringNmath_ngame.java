package prc1.programmers_kit;


public class prog_stringNmath_ngame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=16;
		int t=16;
		int m=2;
		int p=2;
		System.out.println(solution(n,t,m,p));
	}
	public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int charidx=0;
        int num=0;
        String numS="0";
        while(i<=(t-1)*m+p){
            if(charidx>numS.length()-1) {
            	numS=makeN(++num,n);
            	charidx=0;
            	System.out.println(num+"set size:"+charidx);
            	continue;
            }
            if(i%m+1==p){
            	System.out.print("d");
                sb.append(numS.charAt(charidx));
            }
            i++;
            charidx++;
            System.out.println(num+":"+numS);
        }
        return sb.toString();
    }
	public static String makeN(int num,int n) {
		StringBuilder sb = new StringBuilder ();
		if(num==0) return "0";
		while(num!=0) {
			sb.append(Integer.toHexString(num%n).toUpperCase());
			num/=n;
		}
		return sb.reverse().toString();
	}

}

package prc1.kakao;
import java.util.LinkedHashSet;
import java.util.Iterator;

class kakao_Æ©ÇÃ {
	static LinkedHashSet <Integer> hs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.print(solution(s));
	}
	public static int[] solution(String s) {
        int[] answer = {};
        hs= new LinkedHashSet<>();
        s=s.substring(2,s.length()-2);
        String[] str=s.split("\\},\\{");
        int [][] ans=new int[str.length][str.length];
        for(int i=0;i<str.length;i++) {
        	String[] tmp=str[i].split(",");
        	System.out.println(tmp.length);
        	for(int j=0;j<tmp.length;j++) {
        		ans[tmp.length-1][j]=(Integer.parseInt(tmp[j]));
        	}
        }
        for(int i=0;i<str.length;i++) {
        	for(int j=0;j<=i;j++) {
        		hs.add(ans[i][j]);
        		System.out.println(ans[i][j]);
        	}
        }
        Iterator it = hs.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
//        int control=0;
//        while(it.hasNext()) {
//        	answer[control]=(int) it.next();
//        	control++;
//        }
        for(int i=0;i<str.length;i++) {
        	answer[i]=(int) it.next();
        }
        return answer;
    }

}

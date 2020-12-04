package prc1.programmers_kit;

public class prog_string_newscluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="abab"; 
		String b ="cdcdcdabc"; //7 
		System.out.println(solution(a,b));
	}
	public static int solution(String str1, String str2) {
        return (int)(makeJacard(str1,str2)*65536);
    }
	public static int makeJacard(String str1,String str2){
        str1=str1.toUpperCase();
        str2=str2.toUpperCase();
        StringBuilder sb_str1 = new StringBuilder();
        StringBuilder sb_str2 = new StringBuilder();
        int sum=0;
        int inner=0;
        
        for(int i=0;i<str1.length()-1;i++){ //���ڿ� �̾Ƴ���
            char a=str1.charAt(i);
            char b=str1.charAt(i+1);
            if(a>=65 && a<=90 &&b>=65 && b<=90) sb_str1.append(a+""+b+" ");
        }
        for(int i=0;i<str2.length()-1;i++){
            char a=str2.charAt(i);
            char b=str2.charAt(i+1);
            if(a>=65 && a<=90 &&b>=65 && b<=90) sb_str2.append(a+""+b+" ");
        }
        
        String s1=sb_str1.toString(); //replaceAll�� ���� ���� �ٽ� string��ȯ
        String s2=sb_str2.toString();
        while(s1.length()!=0){
            String comp=s1.substring(0,3); //"ab " ������� ������ ��
            System.out.println(comp);
            int len1=s1.length();
            int len2=s2.length();
            s1=s1.replaceAll(comp,"");
            s2=s2.replaceAll(comp,"");
            len1-=s1.length(); //��������-�����ѱ��� = ������ ���ڿ� �ѱ���
            len2-=s2.length();
            sum+=Math.max(len1,len2)/3; //�ѱ���/3 �ϸ� ��� �����ߴ��� �� �� ����
            inner+=Math.min(len1,len2)/3;
        }
        if(s2.length()!=0) sum+=s2.length()/3;
    
        return inner==0 && sum==0?65536:(int)(((double)inner/(double)sum)*65536);
    }


}

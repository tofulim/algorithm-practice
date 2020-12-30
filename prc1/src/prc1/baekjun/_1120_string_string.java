package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _1120_string_string {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		
		int alen=a.length();
		int answer=alen;
		for(int i=0;i<=b.length()-alen;i++) {
			int tmp_answer=0;
			for(int j=0;j<alen;j++) {
				if(a.charAt(j)!=b.charAt(i+j)) tmp_answer++;
			}
			answer=Math.min(answer, tmp_answer);
		}
		System.out.println(answer);

	}

}

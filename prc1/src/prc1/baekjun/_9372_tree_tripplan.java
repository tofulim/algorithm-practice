package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _9372_tree_tripplan {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nation=Integer.parseInt(st.nextToken());
			
			int plane=Integer.parseInt(st.nextToken());
			for(int j=0;j<plane;j++) {
				st = new StringTokenizer(br.readLine());
			}
			System.out.println(nation-1);
		}

	}

}

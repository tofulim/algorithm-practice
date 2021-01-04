package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816_ds_numCard2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n =Integer.parseInt(br.readLine());
		
		HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			map.put(num,map.getOrDefault(num, 0)+1);
		}
		
		int m =Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for(int j=0;j<m;j++) {
			int num=Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(num,0)+" ");
		}
		
		System.out.print(sb.toString());
	}

}

package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class _1158_datastructure_josephus {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		ArrayList<Integer> al= new ArrayList<Integer> ();
		for(int i=0;i<n;i++) al.add(i+1);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int idx=0;
		int iter=0;
		while(n!=0) {
			if(idx>=al.size()) idx=0;
			if(iter==k-1) {
				if(n==1) sb.append(al.get(idx)+">");
				else sb.append(al.get(idx)+", ");
				al.remove(idx);
				n--;
				iter=0;
			}
			else {
				iter++;
				idx++;
			}
		}
		
		System.out.print(sb.toString());
	}

}

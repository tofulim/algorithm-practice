package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _1717_data_structure_expressionOfset {

	static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		parent=new int[n+1];
		for(int i=1;i<=n;i++) parent[i]=i;
		
		for(int j=0;j<m;j++) {
			st = new StringTokenizer(br.readLine());
			int var =Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
			int big = Integer.parseInt(st.nextToken());
			if(small>big) {
				int tmp=small;
				small=big;
				big=tmp;
			}
			
			if(var==0) { //0¿œ ∂ß
				union(small,big);
			}
			else {
				if(isSameParent(small,big)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	public static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x!=y) {
			parent[y]=x;
		}
	}
	public static boolean isSameParent(int x,int y) {
		x=find(x);
		y=find(y);
		if(x!=y) return false;
		else return true;
	}
	public static int find(int x) {
		if(x==parent[x]) return x;
		else {
			return parent[x]=find(parent[x]);
		}
	}

}

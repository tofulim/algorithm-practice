package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10868_segmenttree_min {
	
	static long [] arr;
	static long [] seg_tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new long[n];
		int seg_level=1;
		while(Math.pow(2, seg_level)<n) seg_level++;
		seg_tree=new long[n*seg_level];
		
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(br.readLine());
		
		min_tree_init(0,n-1,1);
		
		int start,end=0;
		for(int j=0;j<m;j++) {
			st = new StringTokenizer(br.readLine());
			start=Integer.parseInt(st.nextToken());
			end=Integer.parseInt(st.nextToken());
			sb.append(get_min(0,n-1,start-1,end-1,1));
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static long min_tree_init(int start,int end,int node) {
		if(start==end) return seg_tree[node]=arr[start];
		int mid=(start+end)/2;
		return seg_tree[node]=Math.min(min_tree_init(start,mid,node*2),min_tree_init(mid+1,end,node*2+1));
	}
	
	public static long get_min(int start,int end, int left,int right, int node) {
		if(left>end || right<start) return 1000000000;
		else if(left<=start && right>= end) return seg_tree[node];
		int mid=(start+end)/2;
		return Math.min(get_min(start,mid,left,right,node*2),get_min(mid+1,end,left,right,node*2+1));
	}

}

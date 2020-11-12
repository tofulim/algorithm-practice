package prc1.baekjun;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11505_segmenttree_productofRange {
	
	static long [] arr;
	static long [] seg_tree;
	static final long DIVIDE_NUMBER = 1000000007;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		int seg_level=1;
		while(Math.pow(2, seg_level)<n) seg_level++;
		seg_tree=new long[n*seg_level];
		
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(br.readLine());
		
		product_tree_init(0,n-1,1);
		int command,first,second=0;
		for(int j=0;j<m+k;j++) {
			st = new StringTokenizer(br.readLine());
			command = Integer.parseInt(st.nextToken());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			if(command==1) {
				arr[first-1]=second;
				update(0,n-1,first-1,second,1);
			}
			else {
				sb.append(get_product(0,n-1,first-1,second-1,1));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	
	public static long product_tree_init(int start, int end, int node) {
		if(start==end) return seg_tree[node]=arr[start];
		int mid=(start+end)/2;
		return seg_tree[node]=(product_tree_init(start,mid,node*2)*product_tree_init(mid+1,end,node*2+1))%DIVIDE_NUMBER;
	}
	
	public static long get_product(int start,int end, int left,int right, int node) {
		if(left>end || right<start) return 1;
		else if(left<=start && right>= end) return seg_tree[node];
		int mid=(start+end)/2;
		return (get_product(start,mid,left,right,node*2)*get_product(mid+1,end,left,right,node*2+1))%DIVIDE_NUMBER;
	}
	
	public static long update(int start, int end, int idx, long value, int node) {
		if(start>idx || end<idx) return seg_tree[node];
		else if(start==end) return seg_tree[node]=value;
		int mid=(start+end)/2;
		return seg_tree[node]=(update(start,mid,idx,value,node*2)*update(mid+1,end,idx,value,node*2+1))%DIVIDE_NUMBER;
	}
	
}
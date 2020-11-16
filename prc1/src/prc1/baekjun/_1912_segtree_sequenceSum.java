package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1912_segtree_sequenceSum {
	
	static long [] seg_tree;
	static long [] arr;
	static long max_sum;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int n=Integer.parseInt(br.readLine());
		int seg_level=1;
		while(Math.pow(2, seg_level)<n) seg_level++;
		seg_tree=new long [seg_level*n];
		arr=new long[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
		init(0,n-1,1);
		System.out.println(Arrays.toString(seg_tree));
		max_sum=get_maxsum(0,n-1,1);
		System.out.println(max_sum);

	}
	
	public static long init(int start,int end, int node) {
		if(start==end) return seg_tree[node]=arr[start];
		int mid=(start+end)/2;
		long left=init(start,mid,node*2);
		long right=init(mid+1,end,node*2+1);
		return seg_tree[node]=Math.max(left+right, Math.max(left, right));
	}
	
	public static long get_maxsum(int start,int end,int node) {
		if(start==end) return Math.max(seg_tree[node], max_sum);
		int mid=(start+end)/2;
		return max_sum=Math.max(get_maxsum(start,mid,node*2),get_maxsum(mid+1,end,node*2+1));
	}

}

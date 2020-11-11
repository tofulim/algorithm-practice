package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _2357_segmenttree_minmax {
	
	static long[] arr;
	static long [] min_seg_tree;
	static long [] max_seg_tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int cline = Integer.parseInt(st.nextToken());
		arr=new long[n];
		int seg_level=1;
		while(Math.pow(2, seg_level)<n) seg_level++; 
		min_seg_tree=new long[n*seg_level];
		max_seg_tree=new long[n*seg_level];
		
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(br.readLine());
		min_init(0,n-1,1,1000000000);
		max_init(0,n-1,1,0);
		
		for(int j=0;j<cline;j++) {
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			long min=get_min(0,n-1,start-1,end-1,1,1000000000);
			long max=get_max(0,n-1,start-1,end-1,1,0);
			System.out.println(min+" "+max);
		}

	}
	
	public static long min_init(int start, int end, int node,long min) {
		if(start==end) return min_seg_tree[node]= arr[start];
		int mid=(start+end)/2;
		return min_seg_tree[node]=Math.min(min_init(start,mid,node*2,min),min_init(mid+1,end,node*2+1,min));
	}
	public static long max_init(int start, int end, int node,long max) {
		if(start==end) return max_seg_tree[node]= arr[start];
		int mid=(start+end)/2;
		return max_seg_tree[node]=Math.max(max_init(start,mid,node*2,max),max_init(mid+1,end,node*2+1,max));
	}
	
	public static long get_min(int start, int end, int left,int right, int node, long min) {
		if(left> end || right<start) return 1000000000;
		else if(left<=start && right>=end) return min_seg_tree[node];
		int mid=(start+end)/2;
		
		return Math.min(get_min(start,mid,left,right,node*2,min),get_min(mid+1,end,left,right,node*2+1,min));
	}
	public static long get_max(int start, int end, int left,int right, int node, long max) {
		if(left> end || right<start) return 0;
		else if(left<=start && right>=end) return max_seg_tree[node];
		int mid=(start+end)/2;
		
		return Math.max(get_max(start,mid,left,right,node*2,max),get_max(mid+1,end,left,right,node*2+1,max));
	}
}
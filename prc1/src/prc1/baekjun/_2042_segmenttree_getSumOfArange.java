package prc1.baekjun;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2042_segmenttree_getSumOfArange {
	
	static long [] arr ;
	static long [] seg_tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		arr=new long[n];
		int treesize=1;
		while(Math.pow(2,treesize)<n) {
			treesize++;
		}
		seg_tree=new long[n*treesize];
		
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(br.readLine());
		
		init(0,n-1,1);
		for(int j=0;j<m+k;j++) {
			st = new StringTokenizer(br.readLine());
			int UorS=Integer.parseInt(st.nextToken());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			if(UorS==1) { //update
				long diff= second-arr[first-1];
				update(0,n-1,first-1,diff,1);
				arr[first-1]=second;
			}
			else System.out.println(get_sum(0,n-1,first-1,second-1,1));
		}

	}
	
	public static long init(int start, int end, int node) {
		if(start==end) return seg_tree[node]=arr[start];
		int mid=(start+end)/2;
		return seg_tree[node]=init(start,mid,node*2)+init(mid+1,end,node*2+1);
	}
	
	public static long get_sum(int start,int end,int left, int right, int node) {
		if(left>end || right<start) return 0;
		else if(start>=left && end<=right) return seg_tree[node];
		else {
			int mid=(start+end)/2;
			return get_sum(start,mid,left,right,node*2)+get_sum(mid+1,end,left,right,node*2+1);
		}
	}
	
	public static void update(int start, int end, int idx, long value, int node) {
		if(idx<start || idx>end) return;
		seg_tree[node]+=value;
		if(start==end) return;
		int mid=(start+end)/2;
		update(start,mid,idx,value,node*2);
		update(mid+1,end,idx,value,node*2+1);
	}

}

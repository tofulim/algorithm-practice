package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _2357_segmenttree_minmax_notsolve {
	
	static int [] arr;
	static long [][] seg_tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int cline = Integer.parseInt(st.nextToken());
		arr=new int[n];
		
		int seg_level=1;
		while(Math.pow(2, seg_level)<n) seg_level++; 
		seg_tree=new long[n*seg_level][2];
		
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(br.readLine());
		init(0,n-1,1,1000000000,0);
		
		for(int j=0;j<cline;j++) {
			st = new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			long [] answer=get_minmax(0,n-1,start-1,end-1,1,1000000000,0);
			System.out.println(answer[0]+" "+answer[1]);
		}

	}
	
	public static long[] init(int start, int end, int node,long min,long max) {
		if(start==end) {
			seg_tree[node][0]= arr[start];
			seg_tree[node][1]= arr[start];
			return seg_tree[node];
		}
		int mid=(start+end)/2;
		seg_tree[node][0]=Math.min(init(start,mid,node*2,min,max)[0],init(mid+1,end,node*2+1,min,max)[0]);
		seg_tree[node][1]=Math.max(init(start,mid,node*2,min,max)[1],init(mid+1,end,node*2+1,min,max)[1]);
		return seg_tree[node];
	}
	public static long[] get_minmax(int start, int end, int left,int right, int node, long min, long max) {
		long [] tmp= new long[2];
		if(left> end || right<start) {
			tmp[0]=1000000000;
			tmp[1]=0;
			return tmp;
		}
		else if(left<=start && right>=end){
			return seg_tree[node];
		}
		int mid=(start+end)/2;
		tmp[0]=Math.min(get_minmax(start,mid,left,right,node*2,min,max)[0],get_minmax(mid+1,end,left,right,node*2+1,min,max)[0]);
		tmp[1]=Math.max(get_minmax(start,mid,left,right,node*2,min,max)[1],get_minmax(mid+1,end,left,right,node*2+1,min,max)[1]);
		return tmp;
	}
}
package prc1.baekjun;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class _9934_pbt {

	static int [] arr;
	static ArrayList<Integer> [] lev_arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int level =Integer.parseInt(br.readLine());
		lev_arr = new ArrayList[level+1];
		for(int j=0;j<level;j++) {
			lev_arr[j]=new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr=new int[(int)Math.pow(2, level)-1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int start=arr.length/2;
		lev_arr[level-1].add(arr[start]);
		searchTree(start,level-1);
		for(int i=level-1;i>=0;i--) {
			for(int j=0;j<lev_arr[i].size();j++) {
				System.out.print(lev_arr[i].get(j));
				if(j!=lev_arr[i].size()-1) System.out.print(" ");
			}
			if(i!=0) System.out.println();
		}
		
	}
	public static void searchTree(int start, int level) {
		if(level==0) return;
		else {
			int change_val=(int)Math.pow(2, level-1);
			lev_arr[level-1].add(arr[start-change_val]);
			lev_arr[level-1].add(arr[start+change_val]);
			searchTree(start-change_val,level-1);
			searchTree(start+change_val,level-1);
		}
	}

}

package prc1.programmers_kit;
import java.util.*;
public class prog_binarysearch_ipguk {
	static long ans=Long.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {1000000000,1000000000,1000000000};
		solution(3,s);
	}
	public static long solution(long n, int[] times) {
        Arrays.sort(times);
        ans=binarySearch(times,n);
        return ans;
        
    }
	public static long binarySearch(int[] times,long n) {
		long mid;
		long l=1;
        long r=n*(long)times[times.length-1];
		while(l<=r) {
			mid=(l+r)/2;
			if(checker(mid,times)==n) {
				System.out.println("´ä : "+mid);
				
			}
			else if(checker(mid,times)<n) l=mid+1;
			else r=mid-1;
		}
		System.out.println("0ÀÏ‹š´ä : "+times[0]);
		return times[0];
	}
	public static long checker(long t,int[] times) {
		long sum=0;
		for(int i=0;i<times.length;i++) {
			sum+=t/(long)times[i];
		}
		return sum;
	}

}

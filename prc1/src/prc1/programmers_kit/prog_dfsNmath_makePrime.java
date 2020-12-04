package prc1.programmers_kit;

import java.util.Arrays;

public class prog_dfsNmath_makePrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= {1,2,7,6,4};
		System.out.println(solution(nums));
	}
	static int answer=0;
	static boolean visit[];
	static int[] arr;
	public static int solution(int[] nums) {
		visit= new boolean [nums.length];
		Arrays.fill(visit, false);
		arr=nums;
        for(int i=0;i<nums.length-2;i++) {
        	visit[i]=true;
        	dfs(i,nums[i],1);
        	visit[i]=false;
        }
        
        return answer;
    }
	public static void dfs(int idx,int sum,int level) {
		if(level==3) {
			if(isPrime(sum)) answer++;
		}
		else if(level==1 && idx<arr.length-1) {
			for(int i=idx+1;i<arr.length-1;i++) {
				if(!visit[i]) {
					visit[i]=true;
					dfs(i,sum+arr[i],level+1);
					visit[i]=false;
				}
			}
		}
		else if(level==2){
			for(int i=idx+1;i<arr.length;i++) {
				if(!visit[i]) {
					visit[i]=true;
					dfs(i,sum+arr[i],level+1);
					visit[i]=false;
				}
			}
		}
	}
	public static boolean isPrime(int n) {
		for(int i=3;i<n;i++) if(n%i==0) return false;
		return true;
	}

}

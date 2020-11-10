package prc1.programmers_kit;
import java.util.*;
public class prog_binaryS1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] e = {120, 110, 140, 150};
		solution(e,485);
	}
	public static int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);
        int sum=0;
        for(int i=0;i<budgets.length;i++) {
        	sum+=budgets[i];
        }
        int avg=sum/budgets.length;
        int mavg=M/budgets.length;
//        int newArr[]=new int[avg-mavg];
//        newArr[0]=mavg;
//        for(int m=1;m<newArr.length;m++) {
//        	newArr[m]=newArr[m-1]+1;
//        }
        for(int j=mavg+1;j<avg;j++) {
        	int sumtmp=sum;
        	int idx=binarySearch(budgets, 0, budgets.length-1,j)+1;
        	for(int k=idx;k<budgets.length;k++) {
        		System.out.println("sumtmp, budgets[k], j"+sumtmp+":"+budgets[k]+":"+j+":"+k);
        		sumtmp-=(budgets[k]-j);
        	}
        	if(sumtmp<=M && budgets.length-(idx+1)>(M-sumtmp)) {
        		System.out.println(M+": "+sumtmp+": "+budgets.length+": "+idx+1);
        		answer=j;
        		break;
        	}
        }
        System.out.println(answer);
        return answer;
    }
	public static int binarySearch(int[] budgets,int start, int end, int key) {
		int mid=0; //idx
		while(start<=end) {
			System.out.println(mid);
			mid=(end+start)/2;
			if(budgets[mid]>key) end=mid-1;
			else if(budgets[mid]<key) start=mid+1;
			else break;
		}
		return mid; //mid는 key값과 같거나 바로 다음 값이 됨
	}

}

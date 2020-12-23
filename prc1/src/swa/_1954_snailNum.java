package swa;
import java.util.Scanner;

public class _1954_snailNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            int [][] arr = new int[n][n];
            snail(arr,n);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
             	for(int j=0;j<n;j++){
                 	sb.append(arr[i][j]+" ");   
                }
                sb.append("\n");
            }
            System.out.print("#"+test_case+"\n"+sb.toString());
		}
	}
    public static void snail(int [][]arr, int n){
        int []x = {1,0,-1,0};
        int []y = {0,1,0,-1};
     	int num=1;
        int max=n*n+1;
        int dir=0;
        int nextx=-1;
        int nexty=0;
        while(num<max){
            while(nextx+x[dir]<0 || nextx+x[dir]>=n || nexty+y[dir]<0 || nexty+y[dir]>=n || arr[nexty+y[dir]][nextx+x[dir]]!=0) {
             	dir++;
                if(dir==4) dir=0;
            }
            nextx+=x[dir];
            nexty+=y[dir];
            arr[nexty][nextx]=num++;
        }
    }
}

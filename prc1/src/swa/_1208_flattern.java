package swa;
import java.util.Scanner;
import java.util.Arrays;

public class _1208_flattern {

	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n=sc.nextInt();
            int [] arr= new int[100];
            int avg=0;
            for(int i=0;i<100;i++) {
                arr[i]=sc.nextInt();
                avg+=arr[i];
            }
            avg/=100;
			Arrays.sort(arr);
            int i=0;
            int j=99;
            int cnt=0;
            while((arr[i]!=avg && arr[i]!=avg+1) && (arr[j]!=avg)){
             	if(cnt==n) break;
                arr[j]-=1;
                arr[i]+=1;
                Arrays.sort(arr);
                cnt++;
            }
            System.out.println("#"+test_case+" "+(arr[j]-arr[i]));
		}
	}
}
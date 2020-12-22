package swa;
import java.util.Scanner;
import java.io.FileInputStream;

public class _1859_biliproject {

	static int [] arr;
    static long answer;
	public static void main(String args[]) throws Exception
	{ //재귀풀이
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            arr = new int[n];
			for(int i=0;i<n;i++) arr[i]=sc.nextInt();
            answer=0;
            cycle(0,n-1);
            System.out.println("#"+test_case+" "+answer);
		}
	}
    public static void cycle(int start, int end){
     	if(start>=end) return; //원소가 하나뿐이 없거나 범위를 벗어나면 종료
        int max=0;
        int idx=start;
        for(int i=start;i<=end;i++){ //가장 큰 원소를 찾는 과정
         	   if(arr[i]>max) {
                   max=arr[i];
                   idx=i;
               }
        }
        if(idx==start) cycle(start+1,end); //찾았으나 첫번째 idx에 있으면 소용이 없음 다음으로
        else {
            for(int j=start;j<idx;j++){ //max까지 풀매수
             	   answer+=max-arr[j];
            }
            cycle(idx+1,end); //다음 max를 찾아 떠남
        }
    }
//    public static void main(String args[]) throws Exception //뒷걸음질 풀이
//	{
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
//
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			int n=sc.nextInt();
//            int [] arr = new int[n];
//			for(int i=0;i<n;i++) arr[i]=sc.nextInt();
//            long answer=0;
//            int max=arr[n-1]; //맨 마지막으로 max로 가정
//            for(int j=n-2;j>=0;j--){
//                if(arr[j]>max) max=arr[j]; //자기보다 큰 수 만나면 max 변경
//                else {
//                    answer+=max-arr[j]; //풀매수
//                }
//            }
//            System.out.println("#"+test_case+" "+answer);
//		}
//	}

}
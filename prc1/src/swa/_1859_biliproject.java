package swa;
import java.util.Scanner;
import java.io.FileInputStream;

public class _1859_biliproject {

	static int [] arr;
    static long answer;
	public static void main(String args[]) throws Exception
	{ //���Ǯ��
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
     	if(start>=end) return; //���Ұ� �ϳ����� ���ų� ������ ����� ����
        int max=0;
        int idx=start;
        for(int i=start;i<=end;i++){ //���� ū ���Ҹ� ã�� ����
         	   if(arr[i]>max) {
                   max=arr[i];
                   idx=i;
               }
        }
        if(idx==start) cycle(start+1,end); //ã������ ù��° idx�� ������ �ҿ��� ���� ��������
        else {
            for(int j=start;j<idx;j++){ //max���� Ǯ�ż�
             	   answer+=max-arr[j];
            }
            cycle(idx+1,end); //���� max�� ã�� ����
        }
    }
//    public static void main(String args[]) throws Exception //�ް����� Ǯ��
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
//            int max=arr[n-1]; //�� ���������� max�� ����
//            for(int j=n-2;j>=0;j--){
//                if(arr[j]>max) max=arr[j]; //�ڱ⺸�� ū �� ������ max ����
//                else {
//                    answer+=max-arr[j]; //Ǯ�ż�
//                }
//            }
//            System.out.println("#"+test_case+" "+answer);
//		}
//	}

}
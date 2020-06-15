package prc1;
import java.util.Scanner;

public class coin2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,coinN,cost;
		n=sc.nextInt();
		for(int i=0;i<n;i++) {
			coinN=sc.nextInt();
			int[] coinCost=new int[coinN]; 
			for(int j=0;j<coinN;j++) {
				coinCost[j]=sc.nextInt();
			}
			cost=sc.nextInt(); //µ·°ª ¹ÞÀ½
			int[] arr=new int[cost+1];
			arr[0]=1;
			for(int k=0;k<coinN;k++) {
				for(int kk=coinCost[k];kk<cost+1;kk++) {
					arr[kk]+=arr[kk-coinCost[k]];
				}
			}
			
			System.out.println(arr[cost]);
		}

	}

}

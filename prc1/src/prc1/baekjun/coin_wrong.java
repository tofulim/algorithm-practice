package prc1.baekjun;
import java.util.Scanner;

public class coin_wrong {
	
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
			int[][] arr=new int[coinN+1][cost+1];
			for(int k=1;k<coinN+1;k++) {
				for(int kk=1;kk<cost+1;kk++) {
					if(coinCost[k-1]==1) {arr[k][kk]=1;}
					else if(coinCost[k-1]>kk) {arr[k][kk]=0;}
					else { 
						if(k==1) {
							if(kk%coinCost[k-1]==0) arr[k][kk]=1; 
						}
						else {
							int n2=kk/coinCost[k-1];
							if(kk%coinCost[k-1]==0) arr[k][kk]++;
							for(int m=1;m<n2+1;m++) {
								if(arr[k-1][(kk-m*coinCost[k-1])]!=0) {
									arr[k][kk]+=arr[k-1][(kk-m*coinCost[k-1])];
								}
							}
						}
					}
					System.out.print(arr[k][kk]);
				}System.out.println();
			}
			System.out.println(arr[coinN][cost]);
		}

	}

}

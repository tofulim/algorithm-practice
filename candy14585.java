package prc1; //wrong code 
import java.util.Scanner;
public class candy14585 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int candy=sc.nextInt();
		int[] x=new int[n];
		int[] y=new int[n];
		for(int i=0;i<n;i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		int sum=0;
		int locx=0;
		int locy=0; 
		int j;
		int xx;
		int yy;
		int[] dp=new int[n];
		for(j=0;j<n;j++) {
			xx=x[j]-locx; yy=y[j]-locy;
			if(xx>=0&&yy>=0) candy=candy-(x[j]-locx+y[j]-locy);
			else continue;
			if(candy>0) {
				sum+=candy;
				locx=x[j];locy=y[j];
				}
			else break;		
		}System.out.println(sum);
	}

}

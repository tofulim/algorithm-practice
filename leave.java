package prc1;
import java.util.Scanner;

public class leave {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int day=sc.nextInt();
		int[] t=new int[day+1];
		int[] p=new int[day+1];
		for(int i=1;i<day+1;i++) {
			t[i]=sc.nextInt();
			p[i]=sc.nextInt();
		}
		int sum=0;
		for(int k=1;k<day+1;k++) {
			if(t[k]+k-1>day) continue;
			int sum1=p[k];
			int sum2=0;
			boolean fl=true;
			for(int kk=k+1;kk<t[k]+k;kk++) {
				if(t[kk]+kk-1<=t[k]+k-1) { //기간 내에 기간에 포함될 때
					sum2+=p[kk];
					if(sum2>=sum1) {fl=false;break;}
					kk+=t[kk];
				}//여기에 마지막 예제가 안됨, 다음 놈이 전놈 기간보다 크지만 그게 더 이득일 때 구현해야하는데 함수로 만들어서 매개변수 받아서 
				//거기서부터 하는건 어떨지
				else if(p[kk]>p[k]){
					
				}
			}
			if(sum1>sum2) {
				sum+=sum1; k=k+t[k]-1;
				System.out.println(sum+"&1"+k);
			}
			else if(fl==true) sum+=sum2; System.out.println(sum+"&2"+k);
		}
		System.out.println(sum);
	}

}

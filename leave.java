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
				if(t[kk]+kk-1<=t[k]+k-1) { //�Ⱓ ���� �Ⱓ�� ���Ե� ��
					sum2+=p[kk];
					if(sum2>=sum1) {fl=false;break;}
					kk+=t[kk];
				}//���⿡ ������ ������ �ȵ�, ���� ���� ���� �Ⱓ���� ũ���� �װ� �� �̵��� �� �����ؾ��ϴµ� �Լ��� ���� �Ű����� �޾Ƽ� 
				//�ű⼭���� �ϴ°� ���
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

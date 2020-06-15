package prc1;
import java.util.*;

public class sopung {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt(); //tc¼ö
		for(int i=0;i<n;i++) {
			int sum=0;
			int n_student=sc.nextInt(); //ÇÐ»ý¼ö ½Ö ¼ö
			int n_pair=sc.nextInt(); //½Ö
			boolean[] person=new boolean[n_student];
			int [][] comp=new int[n_pair][n_student/2];
			int number=2*n_pair; //ÀÎµ¦½º
			int[] parray=new int[number];
			for(int j=0;j<number;j++) {
				parray[j]=sc.nextInt(); //½Ö Áý¾î³Ö±â
			}
			int cont=0;
			for(int k=0;k<n_pair;k++) {
				int check=2; //number°ü¸®ÇÏ´Â ¼ýÀÚ
				Arrays.fill(person, false);
				person[parray[2*k]]=true;person[parray[2*k+1]]=true;
				comp[cont][0]=k;
				int controller=1;
				int k2=k;
				int count=1;
				while(check<number) { 
					if(k2==n_pair-1) k2=-1;
					if(person[parray[2*(k2+1)]]==true||person[parray[2*(k2+1)+1]]==true) {
						check=check+2; k2=k2+1; 
					}
					else if(person[parray[2*(k2+1)]]==false&&person[parray[2*(k2+1)+1]]==false)
					{
						person[parray[2*(k2+1)]]=true;person[parray[2*(k2+1)+1]]=true;
						comp[cont][controller++]=k2+1;
						check=check+2; k2=k2+1; count++;
					}
				}
				
				if(count==n_student/2) {
					Arrays.sort(comp[cont]); 
					cont++; sum++;	
					for(int kkk=0;kkk<n_student/2;kkk++) {
						System.out.print(comp[cont-1][kkk]+" ");
					}System.out.println();
				}
				else {if(cont!=0)cont--;}
			}
			int ans=sum;
			
			for(int kk=0;kk<sum-1;kk++) {
				for(int jj=kk+1;jj<sum;jj++) {
					for(int mm=0;mm<n_student/2;mm++) {
						if(comp[kk][mm]!=comp[jj][mm]) break;
						else if(mm==(n_student/2)-1)ans--;
					}
				}
			}
			
			System.out.print(ans);
		}
		sc.close();
	}
}

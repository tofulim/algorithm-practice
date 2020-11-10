package prc1.baekjun;
import java.util.Scanner;
import java.util.LinkedList;

public class editor {
	static LinkedList<Character> list=new LinkedList<Character>();
	static int cnt,curser=0;
	static String input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input=sc.nextLine();
		int s=input.length();
		curser=s; //커서가 맨끝+1에 가있어서 왼쪽에 커서가 있음
		cnt=s;
		for(int j=0;j<s;j++) {
			list.add(input.charAt(j));
		}
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			input=sc.nextLine();
			if(input.charAt(0)=='L'){
				if(curser!=0) curser--;
			}
			else if(input.charAt(0)=='D'){
				if(curser!=cnt) curser++;
			}
			else if(input.charAt(0)=='B'){
				if(curser!=0) {
					list.remove(curser-1); curser--; cnt--;
				}
			}
			else if(input.charAt(0)=='P'){
				list.add(curser,input.charAt(2));
				curser++; cnt++;
			}
		}
		for(int k=0;k<cnt;k++) {
			System.out.print(list.get(k));
		}
		return ;
	}

}

package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _15686_implement_chickendelivery {
	static boolean [] visit ;
	static int mindis;
	static ArrayList<House> home;
	static int m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int [][]arr=new int[n][n];
		home = new ArrayList<>();
		ArrayList<Chicken> chick=new ArrayList<>();
		mindis=1000000;
		for(int i=0;i<n;i++) { //�ʱ�ȭ
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					home.add(new House(i,j));
				}
				else if(arr[i][j]==2) {
					chick.add(new Chicken(i,j));
				}
			}
		}
		visit=new boolean [chick.size()+1];
		Arrays.fill(visit, false);
		combination(chick,0,0);
		
		System.out.println(mindis);
		
		
	}
	public static void combination(ArrayList<Chicken> chick,int idx,int num) { //������ visit �� üũ���ִ� �Լ�
		if(idx>chick.size()) return;
		if(num==m) { //m���� ������ visit�� üũ ����
			get_city_distance(chick);
			return;
		}
		combination(chick, idx+1,num); // num�� �״�� �� �� ��ĭ �ڷ� ��
		visit[idx]=true; //���� ĭ�� üũ
		combination(chick,idx+1,num+1); // üũ �����Ƿ� �������� �Ѿ
		visit[idx]=false; //üũ�� Ǯ����
	}
	public static void get_city_distance(ArrayList<Chicken> chick) {
		int tmp_mindis=0;
		for(int h=0;h<home.size();h++) { //�ּҰŸ� �����ϱ�
			int temp=9876543;
			House tmp_house = home.get(h);
			int h_x=tmp_house.x;
			int h_y=tmp_house.y;
			for(int c=0;c<chick.size();c++) {
				if(!visit[c]) continue;
				Chicken tmp_chick=chick.get(c);
				int new_distance=Math.abs(h_x-tmp_chick.x)+Math.abs(h_y-tmp_chick.y);
				temp=Math.min(temp, new_distance);
			}
			tmp_mindis+=temp;
		}
		mindis=mindis<tmp_mindis?mindis:tmp_mindis;
	}
	
	public static class Chicken{
		int x,y;
		public Chicken(int y,int x) {
			this.x=x;
			this.y=y;
		}
	}
	public static class House{
		int x,y;
		public House(int y,int x) {
			this.x=x;
			this.y=y;
		}
	}

}

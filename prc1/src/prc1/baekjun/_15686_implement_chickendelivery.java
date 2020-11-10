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
		for(int i=0;i<n;i++) { //초기화
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
	public static void combination(ArrayList<Chicken> chick,int idx,int num) { //순열을 visit 에 체크해주는 함수
		if(idx>chick.size()) return;
		if(num==m) { //m개의 조합을 visit에 체크 했음
			get_city_distance(chick);
			return;
		}
		combination(chick, idx+1,num); // num을 그대로 한 뒤 한칸 뒤로 감
		visit[idx]=true; //현재 칸을 체크
		combination(chick,idx+1,num+1); // 체크 했으므로 다음으로 넘어감
		visit[idx]=false; //체크를 풀어줌
	}
	public static void get_city_distance(ArrayList<Chicken> chick) {
		int tmp_mindis=0;
		for(int h=0;h<home.size();h++) { //최소거리 설정하기
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

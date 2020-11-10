package prc1.programmers_kit;
import java.util.*;
public class prog_hash_4 {
	
	static class Genres{
		String genre;
		public int first=-1;
		public int second=-1;
		public int sum=0;
		public int idx1=-1;
		public int idx2=-1;
		public Genres(String genre, int play) { //������, ó���� new�� ����Ǹ� �帣�� �����Ѵ�
			this.genre=genre;
		}
		public String getGenre() {
			return this.genre;
		}
		public void setPlay(int play, int idx) { //������ Genre ��ü�� ���� ���� ����� ���� �뷡 1 2 �� ������
			this.sum+=play; //�켱 �ش� �帣�� ���Եȴٸ� �� ���� ��� �����ش�
			if(play>this.first) { // �ְ� ��� ����
				this.second=this.first;
				this.idx2=this.idx1;
				this.first=play;
				this.idx1=idx;
			}
			else if(play<this.first&&play>this.second) { //2���� �ְ���
				this.second=play;
				this.idx2=idx;
			}
			else if(play==this.first && play!=this.second) { //ó������ ���� �ι�°���� Ŭ ��� �ε��� ������ ���� �о��
				this.second=play;
				this.idx2=idx;
			}
			//[100,100,100] �� ��� �ڵ����� 0,1�� �� 2���� ���� ����
		}
		public int getFirstidx() {
			return this.idx1; 
		}
		public int getSecondidx() {
			return this.idx2; 
		}
		public int getSum() {
			return this.sum;
		}
		
	}
	public static int[] solution(String[] genres, int[] plays) {
		Genres [] arr=new Genres[genres.length]; //�帣���� �����ϱ� ���� �迭
		int tmp=0; //�帣�� ������ ������
		for(int i=0;i<plays.length;i++) {
			if(i==0) {
				arr[0]=new Genres(genres[i],plays[i]);
				arr[0].setPlay(plays[i], i);
				tmp++;
			}
			else {
				boolean flag=true;
				for(int j=0;j<tmp;j++) { //���� ���� �帣�� �̹� ����Ʈ�� �ִ��� Ȯ��
					if(arr[j].getGenre().equals(genres[i])) { //���� �帣�� ���
						arr[j].setPlay(plays[i], i);
						flag=false; //���� �帣 ������ �־���
						break;
					}
				}
				if(flag) { //���� ������ �帣�� ���
					arr[tmp]=new Genres(genres[i],plays[i]); // ���ο� �帣�� ���� ��ü�� �������
					arr[tmp].setPlay(plays[i], i);
					tmp++; //�帣����++
				}
			}
			
		}
		Genres arr2[]=new Genres[tmp]; //�񱳿����ڷ� �����ϱ� ���� ���ο� �迭�� ����� ��������
		System.arraycopy(arr, 0, arr2, 0, tmp);
		Arrays.sort(arr2,new Comparator<Genres>() {
			@Override
        	public int compare(Genres o1, Genres o2) {
        		if( o1.getSum()<(o2.getSum())) //�帣�� �� ������� �������� ������
                    return 1; 
                else
                    return -1;
            }
        });
		ArrayList<Integer> answer2 = new ArrayList<>(); //������ ��Ƶ� �迭 ����
		
		for(int k=0;k<tmp;k++) {
			answer2.add(arr2[k].getFirstidx()); //1��°�� �ְ�
			if(arr2[k].getSecondidx()!=-1) { //2��°�� �ִٸ� �־���
				answer2.add(arr2[k].getSecondidx());
			}
		}
		int[] answer = answer2.stream().mapToInt(Integer::intValue).toArray(); //arraylist�� �迭�� ����ȯ
        return answer;
    }
	public static void main(String[] args) {
//		String [] board = {"classic", "pop", "classic","hiphop", "classic", "pop","jazz","jazz"};
//		int [] moves = {500, 600, 150,8000, 800, 2500,5000,150};
		String [] board = {"classic", "pop", "classic","hiphop", "classic", "pop","jazz","jazz"};
		int [] moves = {500, 600, 1000,8000, 500, 2500,5000,150};
		solution(board,moves);
		
		return ;

	}
	

}

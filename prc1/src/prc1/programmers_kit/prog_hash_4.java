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
		public Genres(String genre, int play) { //생성자, 처음에 new로 선언되면 장르만 저장한다
			this.genre=genre;
		}
		public String getGenre() {
			return this.genre;
		}
		public void setPlay(int play, int idx) { //생성한 Genre 객체에 가장 많은 재생수 가진 노래 1 2 를 저장함
			this.sum+=play; //우선 해당 장르에 포함된다면 총 합을 계속 구해준다
			if(play>this.first) { // 최고 기록 갱신
				this.second=this.first;
				this.idx2=this.idx1;
				this.first=play;
				this.idx1=idx;
			}
			else if(play<this.first&&play>this.second) { //2번의 최고기록
				this.second=play;
				this.idx2=idx;
			}
			else if(play==this.first && play!=this.second) { //처음꺼랑 같고 두번째보단 클 경우 인덱스 관리를 위해 밀어내줌
				this.second=play;
				this.idx2=idx;
			}
			//[100,100,100] 일 경우 자동으로 0,1로 들어감 2번은 들어가지 않음
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
		Genres [] arr=new Genres[genres.length]; //장르들을 보관하기 위한 배열
		int tmp=0; //장르의 개수를 관리함
		for(int i=0;i<plays.length;i++) {
			if(i==0) {
				arr[0]=new Genres(genres[i],plays[i]);
				arr[0].setPlay(plays[i], i);
				tmp++;
			}
			else {
				boolean flag=true;
				for(int j=0;j<tmp;j++) { //현재 가진 장르가 이미 리스트에 있는지 확인
					if(arr[j].getGenre().equals(genres[i])) { //같은 장르일 경우
						arr[j].setPlay(plays[i], i);
						flag=false; //같은 장르 만나서 넣어줌
						break;
					}
				}
				if(flag) { //새로 들어오는 장르일 경우
					arr[tmp]=new Genres(genres[i],plays[i]); // 새로운 장르에 대한 객체를 만들어줌
					arr[tmp].setPlay(plays[i], i);
					tmp++; //장르개수++
				}
			}
			
		}
		Genres arr2[]=new Genres[tmp]; //비교연산자로 정렬하기 위해 새로운 배열을 만들어 복사해줌
		System.arraycopy(arr, 0, arr2, 0, tmp);
		Arrays.sort(arr2,new Comparator<Genres>() {
			@Override
        	public int compare(Genres o1, Genres o2) {
        		if( o1.getSum()<(o2.getSum())) //장르의 총 재생수로 내림차순 정렬함
                    return 1; 
                else
                    return -1;
            }
        });
		ArrayList<Integer> answer2 = new ArrayList<>(); //정답을 담아둘 배열 선언
		
		for(int k=0;k<tmp;k++) {
			answer2.add(arr2[k].getFirstidx()); //1번째를 넣고
			if(arr2[k].getSecondidx()!=-1) { //2번째가 있다면 넣어줌
				answer2.add(arr2[k].getSecondidx());
			}
		}
		int[] answer = answer2.stream().mapToInt(Integer::intValue).toArray(); //arraylist를 배열로 ㅂ변환
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

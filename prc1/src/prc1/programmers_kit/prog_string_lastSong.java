package prc1.programmers_kit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class prog_string_lastSong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String m ="ABC#ABC#";
		String[] mu= {"00:00,00:06,HELLO,A#BC#", "13:00,13:03,WORLD,ABC"};
		System.out.println(solution(m,mu));
	}
	public static String solution(String m, String[] musicinfos) {
		ArrayList <Song> answer = new ArrayList<>();
        for(int i=0;i<musicinfos.length;i++){
            String []now_music=musicinfos[i].split(",");
            System.out.println(Arrays.toString(now_music));
            int hour=(now_music[1].charAt(0)-now_music[0].charAt(0))*10;
            hour+=now_music[1].charAt(1)-now_music[0].charAt(1);
            int minute=(now_music[1].charAt(3)-now_music[0].charAt(3))*10;
            minute+=now_music[1].charAt(4)-now_music[0].charAt(4);
            int playtime=hour*60+minute;
            
            StringBuilder sb = new StringBuilder();
            int idx=0;
            for(int j=0;j<playtime;j++){
                char nowch;
                if(idx==now_music[3].length()-1) {
                	System.out.println("here");
                	nowch=now_music[3].charAt(idx);
                	sb.append(nowch);
                	idx=0;
                	continue;
                }
                else if(idx>now_music[3].length()-1) {
                	System.out.println("orhere");
                	idx=0;
                	j--;
                	continue;
                }
                nowch=now_music[3].charAt(idx);
                char nextch=now_music[3].charAt(idx+1);        
            	if(nowch!='#' && nextch=='#') {
            		sb.append(nowch+""+nextch);
            		idx+=2;
            	}
            	else if(nowch!='#' && nextch!='#') {
            		sb.append(nowch);
            		idx++;
            	}
            	
            	System.out.println("j"+j+"idx"+idx);
            	System.out.println(sb.toString());
            	
            }
            System.out.println(sb);
            System.out.println(playtime);
            
//            int indexOfMelody=sb.indexOf(m);
            String pattern=".*"+m+"[^#].*|.*"+m;
            System.out.println(sb.toString());
            if(sb.toString().matches(pattern)) answer.add(new Song(playtime,i,now_music[2]));
            System.out.println(sb.toString().matches(pattern));
        }   
        Collections.sort(answer, new Comparator <Song> (){
			@Override
			public int compare(Song o1, Song o2) {
				// TODO Auto-generated method stub
				if(o1.time==o2.time) return o1.idx-o2.idx;
				else return o2.time-o1.time;
			}
        });
        return answer.size()>0?answer.get(0).name:"(None)";
        
    }
    public static class Song{
        int time;
        String name;
        int idx;
        public Song(int time, int idx, String name){
            this.time=time;
            this.idx=idx;
            this.name=name;
        }
    }

}

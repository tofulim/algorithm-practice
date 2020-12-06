package prc1.programmers_kit;
import java.util.ArrayList;
public class prog_datastructure_cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public int solution(int cacheSize, String[] cities) {
		if(cacheSize==0) return cities.length*5;
        int answer = 0;
        ArrayList <String> al = new ArrayList<>();
        for(int i=0;i<cities.length;i++) {
        	String newC=cities[i].toLowerCase();
        	int idx;
        	if(al.size()!=cacheSize) {
        		answer+=5;
        		al.add(newC);
        	}
        	else if((idx=al.indexOf(newC))>-1) {
        		al.remove(idx);
        		al.add(newC);
        		answer+=1;
        	}
        	else {
        		al.remove(0);
        		al.add(newC);
        		answer+=5;
        	}
        }
        return answer;
    }

}

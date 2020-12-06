package prc1.programmers_kit;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;

public class prog_map_failure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int [] stages= {4,4,4,4,4};
		System.out.println(Arrays.toString(solution(n,stages)));
	}
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int [] stack=new int[N+2];
        int [] trying=new int[N+2];
        Map <Integer, Double> m = new HashMap<>();
        for(int i=0;i<stages.length;i++){
            int st=stages[i];
            for(int j=1;j<=st;j++) stack[j]+=1;
            trying[st]+=1;
        }
        for(int k=1;k<=N;k++){
        	if(stack[k]==0) m.put(k, 0.0);
        	else m.put(k,trying[k]/(double)stack[k]);
        }
        System.out.println(m.toString());
        ArrayList<Entry<Integer, Double>> list_entries = new ArrayList<Entry<Integer, Double>>(m.entrySet());
        Collections.sort(list_entries, new Comparator <Entry<Integer,Double>>(){
        	@Override
        	public int compare(Entry<Integer,Double> e1,Entry<Integer,Double> e2) {
        		double e1_val=e1.getValue();
        		double e2_val=e2.getValue();
        		if(e1_val==e2_val) {
        			return e1.getKey()-e2.getKey()<0?-1:1;
        		}
        		else {
        			return e2_val-e1_val>0?1:-1;
        		}
        	}
        });
        int idx=0;
        for(Entry<Integer, Double> ent: list_entries) {
        	answer[idx++]=ent.getKey();
        }
        return answer;
    }

}

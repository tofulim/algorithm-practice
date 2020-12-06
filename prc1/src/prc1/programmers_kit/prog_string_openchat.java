package prc1.programmers_kit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class prog_string_openchat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan","Enter uid1235 Prodo"};
		System.out.println(Arrays.toString(solution(record)));
	}
	public static String[] solution(String[] record) {
        int len=record.length;
        String [][] rec_arr=new String[len][];
        Map <String, String> m=new HashMap<>();
        int cnt=0;
        for(int i=0;i<len;i++){
            rec_arr[i]=record[i].split(" ");
            if(rec_arr[i][0].equals("Enter")) m.put(rec_arr[i][1], rec_arr[i][2]);
            else if(rec_arr[i][0].equals("Change")) {
            	m.put(rec_arr[i][1], rec_arr[i][2]);
            	cnt++;
            }
        }
        String[] answer= new String[len-cnt];
        int idx=0;
        for(int j=0;j<len;j++) {
        	if(rec_arr[j][0].equals("Enter")) answer[idx++]=m.get(rec_arr[j][1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
            else if(rec_arr[j][0].equals("Leave")) answer[idx++]=m.get(rec_arr[j][1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.";
        }
        return answer;
    }

}

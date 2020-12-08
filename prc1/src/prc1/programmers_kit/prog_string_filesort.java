package prc1.programmers_kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class prog_string_filesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files= {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] files1= {"B0050 Freedom Fighter", "B50 Superfortress", "B05 Thunderbolt II", "B14 Tomcat"};
		String[] files2= {"muzi00003", "MUZI00003", "muzi1111", "muzi1111111"};
		
		System.out.println(Arrays.toString(solution(files2)));
	}
	public static String[] solution(String[] files) {
        
        ArrayList <File> al = new ArrayList<>();
        for(int i=0;i<files.length;i++) {
        	int idx=0;
        	StringBuilder head = new StringBuilder();
        	StringBuilder number = new StringBuilder();
        	StringBuilder tail = new StringBuilder();
        	System.out.println("tail"+tail.toString());
        	String now_file=files[i];
        	while(now_file.charAt(idx)<48 || now_file.charAt(idx)>57) {
        		head.append(now_file.charAt(idx));
        		idx++;
        	}
        	System.out.println(head);
        	int cnt=0;
        	while(idx<now_file.length() && now_file.charAt(idx)>=48 && now_file.charAt(idx)<=57) {
        		number.append(now_file.charAt(idx));
        		idx++;
        		cnt++;
        		if(cnt==5) break;
        	}
        	System.out.println(number);
        	while(idx<now_file.length()) {
        		tail.append(now_file.charAt(idx));
        		idx++;
        	}
        	System.out.println(tail);
        	al.add(new File(i,head.toString(),number.toString(),tail.toString()));
        }
        Collections.sort(al, new Comparator <File>() {
        	@Override
        	public int compare(File a, File b) {
        		String fname_a=a.header.toUpperCase();
        		String fname_b=b.header.toUpperCase();
        		if(fname_a.compareTo(fname_b)==0) {
        			int num_a=Integer.parseInt(a.num);
        			int num_b=Integer.parseInt(b.num);
        			if(num_a==num_b) return a.idx-b.idx;
        			else return num_a-num_b;
        		}
        		else return fname_a.compareTo(fname_b);
        	}
        });
        
        String[] answer=new String[al.size()];
        for(int i=0;i<al.size();i++) {
        	File tmp=al.get(i);
        	StringBuilder sb =new StringBuilder ();
        	sb.append(tmp.header).append(tmp.num).append(tmp.tail);
        	answer[i]=sb.toString();
        }
        return answer;
    }
	public static class File{
		int idx;
		String header;
		String num;
		String tail;
		public File(int i,String h, String n, String t) {
			this.idx=i;
			this.header=h;
			this.num=n;
			this.tail=t;
		}
	}

}

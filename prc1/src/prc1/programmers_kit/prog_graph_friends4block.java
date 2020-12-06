package prc1.programmers_kit;

import java.util.Arrays;

public class prog_graph_friends4block {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=6;
		int n=6;
		String[] board= {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m,n,board));
	}
	static int nx[]= {0,1,0,1};
	static int ny[]= {0,0,1,1};
	static int tmp_answer=0;
	static boolean visit[][];
	static StringBuilder sbarr[];
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        visit=new boolean[n][m]; //reverse
        
        sbarr= new StringBuilder[n];
        for(int i=0;i<n;i++) {
        	sbarr[i]=new StringBuilder();
        	for(int j=m-1;j>=0;j--) {
        		sbarr[i].append(board[j].charAt(i));
        	}
        }
        for(boolean[] a : visit ) Arrays.fill(a, false);
        
        while(true) {
        	
        	tmp_answer=0;
        	for(int i=0;i<n-1;i++) {
        		if(sbarr[i].length()>1) {
        			for(int j=0;j<sbarr[i].length()-1;j++) {
               		 	find4(i,j);
        			}
        		}	
            }
        	if(tmp_answer==0) break;
        	answer+=tmp_answer;
        	erase(n,m);
        	for(boolean[] a : visit ) Arrays.fill(a, false);
        }
        
        return answer;
    }
	public static void find4(int i,int j) {
		if(j>=sbarr[i].length()-1) return;
		char c1=sbarr[i].charAt(j);
		char c2=sbarr[i].charAt(j+1);
		if(c1==c2 && sbarr[i+1].length()-1>=j+1 && c1==sbarr[i+1].charAt(j) && c1==sbarr[i+1].charAt(j+1)) {
			for(int k=0;k<4;k++) {
				int newx=j+nx[k];
				int newy=i+ny[k];
				if(!visit[newy][newx]) {
					tmp_answer++;
					visit[newy][newx]=true;
				}
			}
		}
	}
	public static void erase(int n,int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visit[i][j]) sbarr[i].setCharAt(j, ' ');
			}
		}
		for(int i=0;i<n;i++) {
			sbarr[i]=new StringBuilder(sbarr[i].toString().replaceAll(" ", ""));
		}
	}

}

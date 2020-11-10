package prc1.programmers_kit;
import java.util.*;

public class prog_dp1 {
	public class Node{
		public Vector <Integer> cangolist;
		public int distance;
		public Node(int cango) {
			this.cangolist.add(cango);
		}
		public void addlist(int cango) {
			this.cangolist.add(cango);
		}
	}
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        Node list[]=new Node [n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<2;j++) {
        		if(list[edge[i][j]-1]==null) {
        			list[edge[i][j]-1]=new Node(edge[i][1-j]);
        		}
        		else {
        			list[edge[i][j]-1].addlist(edge[i][1-j]);
        		}
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

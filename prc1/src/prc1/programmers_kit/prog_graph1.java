package prc1.programmers_kit;

import java.util.Queue;
import java.util.Vector;
import java.util.Iterator;
import java.util.Arrays;
import java.util.LinkedList;

public class prog_graph1 {
	static Queue <Integer>q=new LinkedList<Integer>(); //bfs를 진행할 큐를 생성
	
	public static int solution(int n, int[][] edge) {
        int answer = 1;
        boolean visit[]=new boolean [n+1]; //false로 초기화
        Vector <Integer> v[]=new Vector [n+1]; // 벡터배열로 각 번호마다 갈 수 있는 리스트를 만듬
        for(int i=1;i<n+1;i++) { //벡터 초기화
        	v[i]=new Vector<Integer>();
        }
        
        for(int i=0;i<edge.length;i++) { //양방향이므로 양쪽으로 넣어줌
        	int first=edge[i][0];
        	int second=edge[i][1];
        	v[first].add(second);
        	v[second].add(first);
        }

        q.offer(1); //초기값 넣어주기
        visit[1]=true;
        int distance[]=new int[n+1]; //1로부터 얼마나 떨어져 있는지 관리하는 배열
        distance[1]=0; //1번은 시작점이므로 0
        int level=0; //깊이
        while(!q.isEmpty()) {
    		int tmp=q.peek();
    		q.poll();
    		level=distance[tmp]; //방금 큐에서 뺀 녀석이 얼마나 떨어진 거리를 갖고 있는지 확인 
    		Iterator <Integer> it=v[tmp].iterator();
    		while(it.hasNext()) {
    			int tmp2=it.next();
    			if(!visit[tmp2]) { //방문 하지 않아 false일 때 방문해주자
    				distance[tmp2]=level+1; //한칸 더 갔으므로 +1해서 저장
    				visit[tmp2]=true; //방문 체크
    				q.offer(tmp2); //큐에 넣음
    			}
    		}
        }
        Arrays.sort(distance); //distance배열을 정렬
        for(int k=distance.length-1;k>1;k--) { //젤 큰값부터 내려오면서 같은 값이 있나 비교함
        	if(distance[k]==distance[k-1]) answer++;
        	else break;
        }
        System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] p = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		solution(6,p);
		
	}
	

}

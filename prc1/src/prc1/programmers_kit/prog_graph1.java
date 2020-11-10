package prc1.programmers_kit;

import java.util.Queue;
import java.util.Vector;
import java.util.Iterator;
import java.util.Arrays;
import java.util.LinkedList;

public class prog_graph1 {
	static Queue <Integer>q=new LinkedList<Integer>(); //bfs�� ������ ť�� ����
	
	public static int solution(int n, int[][] edge) {
        int answer = 1;
        boolean visit[]=new boolean [n+1]; //false�� �ʱ�ȭ
        Vector <Integer> v[]=new Vector [n+1]; // ���͹迭�� �� ��ȣ���� �� �� �ִ� ����Ʈ�� ����
        for(int i=1;i<n+1;i++) { //���� �ʱ�ȭ
        	v[i]=new Vector<Integer>();
        }
        
        for(int i=0;i<edge.length;i++) { //������̹Ƿ� �������� �־���
        	int first=edge[i][0];
        	int second=edge[i][1];
        	v[first].add(second);
        	v[second].add(first);
        }

        q.offer(1); //�ʱⰪ �־��ֱ�
        visit[1]=true;
        int distance[]=new int[n+1]; //1�κ��� �󸶳� ������ �ִ��� �����ϴ� �迭
        distance[1]=0; //1���� �������̹Ƿ� 0
        int level=0; //����
        while(!q.isEmpty()) {
    		int tmp=q.peek();
    		q.poll();
    		level=distance[tmp]; //��� ť���� �� �༮�� �󸶳� ������ �Ÿ��� ���� �ִ��� Ȯ�� 
    		Iterator <Integer> it=v[tmp].iterator();
    		while(it.hasNext()) {
    			int tmp2=it.next();
    			if(!visit[tmp2]) { //�湮 ���� �ʾ� false�� �� �湮������
    				distance[tmp2]=level+1; //��ĭ �� �����Ƿ� +1�ؼ� ����
    				visit[tmp2]=true; //�湮 üũ
    				q.offer(tmp2); //ť�� ����
    			}
    		}
        }
        Arrays.sort(distance); //distance�迭�� ����
        for(int k=distance.length-1;k>1;k--) { //�� ū������ �������鼭 ���� ���� �ֳ� ����
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

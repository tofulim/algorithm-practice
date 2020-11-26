package prc1.programmers_kit;

import java.util.Arrays;

public class prog_dfs_coloringbook {
	static int []dfs_x= {1,0,-1,0};
	static int []dfs_y= {0,1,0,-1};
	static boolean [][] visit;
	static int tmp_size;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] pic=	{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(6,4,pic)));

	}
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new boolean[m][n];
        for(boolean []a : visit) Arrays.fill(a, false);
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(!visit[i][j] && picture[i][j]!=0) {
        			tmp_size=1;
        			visit[i][j]=true;
        			numberOfArea++;
        			dfs(i,j,picture, picture[i][j]);
        			maxSizeOfOneArea=Math.max(maxSizeOfOneArea,tmp_size);
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	public static void dfs(int y, int x, int[][] picture,int val) {
		int newx;
		int newy;
		for(int i=0;i<4;i++) {
			newx=x+dfs_x[i];
			newy=y+dfs_y[i];
			if(newx>=0 && newx<picture[0].length && newy>=0 && newy<picture.length) {
				if(!visit[newy][newx] && picture[newy][newx]==val) {
					visit[newy][newx]=true;
        			tmp_size++;
        			System.out.println(newy+":"+newx);
        			dfs(newy,newx,picture,val);
				}
			}
		}
	}

}

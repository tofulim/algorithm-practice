package prc1.programmers_kit;

public class prog_dp_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=4;
		int n=3;
		int puddle[][]= {{2,2}};
		solution(m,n,puddle);
	}
	public static class Dot{
		public int cnt;
		public int sum;
		Dot(int cnt,int sum){
			this.cnt=cnt+1;
			this.sum=sum;
		}
		public int getDot() {
			return this.cnt;
		}
		public int getSum() {
			return this.sum;
		}
		
	}
	public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        Dot [][] arr=new Dot [m+1][n+1]; //ÀÎµ¦½º ÇÏ³ª¾¿ ¹ÐÀ½
        arr[1][2]=new Dot(1,1);
        arr[2][1]=new Dot(1,1);
        int [][] xy= {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<puddles.length;i++) {
        	arr[puddles[i][0]][puddles[i][1]]=new Dot(-1,-1);
        }
        for(int i=1;i<=m;i++) {
        	for(int j=1;j<=m;j++) {
        		if((i==1 && j==2) || (i==2 && j==1)) continue;
        		if(arr[i][j].getDot()!=-1 ) { //¶Ç¶ûÀÌ ¾Æ´Ò ¶§
        			int minVal=0;
        			int minSum=0;
        			int nowVal=0;
        			int prevSum=0;
        			for(int k=0;k<4;k++) {
        				nowVal=arr[i+xy[k][0]][j+xy[k][1]].getDot();
        				if(nowVal!=-1 && nowVal>0) {
        					if(minVal>0 && minVal>nowVal) {
        						minVal=nowVal;
        						minSum=arr[i+xy[k][0]][j+xy[k][1]].getSum();
        					}
        					else if(minVal==nowVal) minSum+=arr[i+xy[k][0]][j+xy[k][1]].getSum();
        				}
        			}
        			if(nowVal!=0) arr[i][j]=new Dot(minVal+1,minSum);
        		}
        	}
        }
        System.out.println(arr[m][n].getDot()+" : "+arr[m][n].getSum());
        return answer;
    }

}

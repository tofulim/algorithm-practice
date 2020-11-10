package prc1.kakao;

public class kakao_1번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		System.out.print(solution(s,"right"));

	}
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int num[][]= {{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};
        int currL[]= {3,0};
        int currR[]= {3,2};
        for(int n=0;n<numbers.length;n++) {
	        for(int i=0;i<4;i++) { //가로
	        	for (int j=0;j<3;j++) { 
	        		if(num[i][j]==numbers[n]) { //번호 찾음
	        			if(j==2 || j==0) {
	        				if(j==2) {
	        					currR[0]= i;
		        				currR[1]=j;
		        				answer+="R";
	        				}
	        				else {
	        					currL[0]= i;
		        				currL[1]=j;
		        				answer+="L";
	        				}
	        			}
	        			else if(Math.abs(currL[0]-i)+Math.abs(currL[1]-j)<Math.abs(currR[0]-i)+Math.abs(currR[1]-j)) {
	        				currL[0]= i;
	        				currL[1]=j;
	        				answer+="L";
	        			}//외손이 더 가까울때 그리고 3열이 아닐 때
	        			else if(Math.abs(currL[0]-i)+Math.abs(currL[1]-j)>Math.abs(currR[0]-i)+Math.abs(currR[1]-j)) {
	        				currR[0]= i;
	        				currR[1]=j;
	        				answer+="R";
	        			}//오른손일 때 
	        			else if(Math.abs(currL[0]-i)+Math.abs(currL[1]-j)==Math.abs(currR[0]-i)+Math.abs(currR[1]-j)) {
	        				if(hand=="right") {
	        					currR[0]= i;
		        				currR[1]=j;
		        				answer+="R";
	        				}
	        				else if(hand=="left"){
	        					currL[0]= i;
		        				currL[1]=j;
		        				answer+="L";
	        				}
	        			}
	        		}
	        	}
	        }
        }
        
        return answer;
    }

}

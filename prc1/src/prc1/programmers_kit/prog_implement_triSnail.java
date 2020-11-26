package prc1.programmers_kit;
import java.util.*;
public class prog_implement_triSnail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6));
	}
    public static int[] solution(int n) {
        int answer[];
        int number=1;
        int max_num=0;
        for(int i=1;i<=n;i++) max_num+=i;
        answer=new int[max_num];
        int rotation_num=n;
        int [][] arr = new int[n][];
        for(int i=0;i<n;i++) arr[i]=new int[i+1];
        int start=0;
        int end=n-1;
        int idx=0;
        int bidx=n-1;
        while(rotation_num!=0){
            if(rotation_num==0) break;
            for(int i=start;i<=end;i++) { //내려가는 경우
                arr[i][idx]+=number;
                number++;
            }
            idx++;
            start+=2;
            rotation_num--;

            if(rotation_num==0) break;
            for(int j=1;j<=rotation_num;j++) { //오른쪽으로 가는 경우
                arr[end][idx+j-1]+=number++;
            }
            rotation_num--;

            if(rotation_num==0) break;
            for(int j=1;j<=rotation_num;j++) { //올라가는 경우
                arr[end-j][bidx-j]+=number++;
            }
            end-=1;
            bidx-=2;
            rotation_num--;
        }
        int k=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<arr[i].length;j++){
                answer[k++]=arr[i][j];
            }
        }
        return answer;
    }
	

}

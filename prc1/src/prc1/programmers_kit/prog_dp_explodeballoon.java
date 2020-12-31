package prc1.programmers_kit;

public class prog_dp_explodeballoon {

	static int answer=0;
    static int []left;
    static int []right;
    public int solution(int[] a) {
        int len=a.length;
        left = new int[len];
        right = new int[len];
        int min=1000000000;
        left[0]=a[0];
        for(int i=0;i<len;i++){
            if(a[i]<min) {
                min=a[i];
            }
            left[i]=min;
        }
        min=1000000000;
        for(int j=len-1;j>=0;j--){
            if(a[j]<min) {
                min=a[j];
            }
            right[j]=min;
        }
        
        answer=len;
        if(len>2){
           for(int i=1;i<len-1;i++){
            if(a[i]>right[i+1] && a[i]>left[i-1]) answer--;
           }
        } 
        return answer;
    }
}
package swa;
import java.util.*;
import java.io.*;

public class _1444_maxprize {

	static int answer;
    static HashSet <String> hs;
    public static void main(String args[]) throws IOException
    {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num=st.nextToken();
            int change=Integer.parseInt(st.nextToken());
            String [] arr = num.split("");
            answer=0;
            hs= new HashSet <String>();
            cycle(arr,change);   
            System.out.println("#"+test_case+" "+answer);
        }
    }
    public static void cycle(String [] arr, int change){
        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);
        if(hs.contains(sb.toString()+change)) return;
        else hs.add(sb.toString()+change);
        if(change==0) {
            answer=Math.max(Integer.parseInt(sb.toString()),answer);
            return ;
        }
        else {
            for(int i=0;i<arr.length-1;i++){
               for(int j=i+1;j<arr.length;j++){
                    swap(arr,i,j);
                    cycle(arr,change-1);
                    swap(arr,i,j);
               }
            }
        }
    }
    public static void swap(String [] arr, int a, int b){
        String tmp =arr[b];
        arr[b]=arr[a];
        arr[a]=tmp;
    }
}
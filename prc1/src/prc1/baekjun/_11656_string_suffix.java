package prc1.baekjun;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11656_string_suffix {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		String [] arr = new String[len];
		for(int i=0;i<len;i++) {
			arr[i]=s.substring(i);
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(String a : arr) sb.append(a+"\n");
		System.out.print(sb.toString());

	}

}

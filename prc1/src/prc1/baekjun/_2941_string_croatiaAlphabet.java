package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _2941_string_croatiaAlphabet {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String [] alpha= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0;i<alpha.length;i++) {
			if(s.contains(alpha[i])) {
				s=s.replaceAll(alpha[i], "1");
			}
		}
		System.out.println(s.length());
	}

}

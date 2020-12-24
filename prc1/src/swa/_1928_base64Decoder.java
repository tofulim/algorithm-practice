package swa;
import java.io.*;
import java.util.Base64.Decoder;
import java.util.Base64;

public class _1928_base64Decoder {

	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{		
                String text = br.readLine();
                byte[] targetBytes = text.getBytes(); 
                Decoder decoder = Base64.getDecoder(); 
                byte[] decodedBytes = decoder.decode(targetBytes);
				
                System.out.println("#"+test_case+" "+new String(decodedBytes));
		}
	}
}

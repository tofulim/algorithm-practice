package prc1.baekjun;
import java.util.Scanner;

public class _1062_string_tutoring {
    static int N, K, ans;
    static boolean[][] word;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N은 50보다 작거나 같은 자연수
        K = sc.nextInt(); // K는 26보다 작거나 같은 자연수 또는 0

        // N개의 줄에 남극 언어의 단어
        word = new boolean[N][26];
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < tmp.length(); j++) {
                word[i][tmp.charAt(j) - 'a'] = true;
            }
        }
        visit = new boolean[26];
        ans = 0;
        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int index, int depth) {
        if (depth == K) {
            check();
            return;
        }
        for (int i = index; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(i, depth + 1);
                visit[i] = false;
            }
        }

    }

    private static void check() {
        int ret = 0;

        boolean flag = true;
        for (int k = 0; k < N; k++) {
            flag = true;
            for (int i = 0; i < 26; i++) {
                if (word[k][i] && !visit[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ret++;
        }

        ans = Math.max(ret, ans);
    }
}
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.StringTokenizer;
//
//public class _1062_string_tutoring {
//
//	static int answer=0;
//	static boolean [] visit;
//	static String [] arr;
//	static HashSet<Character> hs;
//	static ArrayList<Character> al;
//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		
//		if(k<5) {
//			System.out.println(0);
//			return;
//		}
//		if(k==26) {
//			System.out.println(n);
//			return;
//		}
//		
//		arr=new String[n];
//		
//		hs = new HashSet<Character> ();
//		visit=new boolean[26];
//		Arrays.fill(visit, false);
//		visit['a'-'a']=true;
//		visit['n'-'a']=true;
//		visit['t'-'a']=true;
//		visit['i'-'a']=true;
//		visit['c'-'a']=true;
//		
//		for(int i=0;i<n;i++) {
//			String tmp=br.readLine();
//			arr[i] = tmp.substring(4,tmp.length()-4);
//			for(int j=0;j<arr[i].length();j++) {
//				char tmp_c = arr[i].charAt(j);
//				if(!visit[tmp_c-'a']) hs.add(tmp_c);
//			}
//		}
//		
//		if(!hs.isEmpty()) {
//			al = new ArrayList<>(hs);
//			dfs(0,k,0);
//		}
//		else answer=n;
//		
//		System.out.println(answer);
//	}
//	
//	public static void dfs(int start,int k,int num) {
//		if(num==k-5) {
//			check();
//		}
//		else {
//			for(int i=start;i<al.size();i++) {
//				char c = al.get(i);
//				if(!visit[c-'a']) {
//					visit[c-'a']=true;
//					dfs(start,k,num+1);
//					visit[c-'a']=false;
//				}
//			}
//		}
//	}
//	public static void check() {
//		int tmp_answer=0;
//		for(int i=0;i<arr.length;i++) {
//			String s = arr[i];
//			boolean flag=true;
//			for(int j=0;j<s.length();j++) {
//				if(!visit[s.charAt(j)-'a']) {
//					flag=false;
//					break;
//				}
//			}
//			if(flag) tmp_answer++;
//		}
//		answer=Math.max(tmp_answer, answer);
//	}
//
//}

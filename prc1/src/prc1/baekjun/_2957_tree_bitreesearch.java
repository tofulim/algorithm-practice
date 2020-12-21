package prc1.baekjun;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class _2957_tree_bitreesearch {
	
	static int cnt=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node root = new Node(Integer.parseInt(br.readLine()));
		StringBuilder sb = new StringBuilder();
		sb.append(0+"\n");
		for(int i=1;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			insert(num,root);
			sb.append(cnt+"\n");
		}
		System.out.print(sb.toString());

	}
	public static void insert(int number,Node node) {
		cnt++;
		if(number<node.number) {
			if(node.left!=null) {
				insert(number,node.left);
			}
			else {
				node.left=new Node(number);
			}
		}
		else {
			if(node.right!=null) {
				insert(number,node.right);
			}
			else {
				node.right=new Node(number);
			}
		}
	}
	public static class Node{
		int number;
		Node left;
		Node right;
		public Node(int number) {
			this.number=number;
		}
	}

}

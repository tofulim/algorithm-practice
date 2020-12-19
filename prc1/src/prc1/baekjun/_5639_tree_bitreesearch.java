package prc1.baekjun;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class _5639_tree_bitreesearch {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		int head = Integer.parseInt(str);
		Node root=new Node(head);
		while((str=br.readLine())!=null && str.length() != 0) {
			int next=Integer.parseInt(str);
			Node next_node = new Node(next);
			putNode(root,next_node);
		}
		getBackpatrol(root);
		System.out.print(sb.toString());
	}
	public static class Node{
		Node left;
		Node right;
		int num;
		public Node(int num) {
			this.num=num;
		}
	}
	public static void putNode(Node root, Node start) {
		if(root.num>start.num) {
			if(root.left!=null) putNode(root.left,start);
			else root.left=start;
		}
		else {
			if(root.right!=null) putNode(root.right,start);
			else root.right=start;
		}
	}
	public static void getBackpatrol(Node root) {
		if(root.left!=null) getBackpatrol(root.left);
		if(root.right!=null) getBackpatrol(root.right);
		sb.append(root.num+"\n");
	}

}

package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class _1927_ds_minHeap {
	static int [] heap;
	static int min_idx=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		heap = new int[n+1];
		
		for(int i=0;i<n;i++) {
			int op=Integer.parseInt(br.readLine());
			operation(op);
		}
		System.out.print(sb.toString());
	}
	
	public static void operation(int op) {
		if(op==0) {
			if(min_idx==0) sb.append(0+"\n");
			else {
				makeHeap(min_idx);
				sb.append(heap[1]+"\n");
				swap(1,min_idx);
				heap[min_idx--]=0;
			}
		}
		else {
			heap[++min_idx]=op;
		}
	}
	
	public static void makeHeap(int n) {
		for(int i=n/2;i>0;i--) {
			maxHeapify(i,n);
		}
	}
	
	public static void maxHeapify(int start,int n) {
		int leftChild=start*2;
		int rightChild=start*2+1;
		int k=-1;
		if(leftChild<=n && heap[leftChild]<heap[start]) {
			k=leftChild;
		}
		else k=start;
		
		if(rightChild<=n && heap[rightChild]<heap[k]) {
			k=rightChild;
		}
		
		if(k!=start) {
			swap(k,start);
			maxHeapify(k,n);
		}
		
	}
	public static void swap(int a,int b) {
		int tmp=heap[b];
		heap[b]=heap[a];
		heap[a]=tmp;
	}
//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n=Integer.parseInt(br.readLine());
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
//		
//		for(int i=0;i<n;i++) {
//			int op=Integer.parseInt(br.readLine());
//			if(op==0) {
//				if(pq.isEmpty()) sb.append(0+"\n");
//				else sb.append(pq.poll()+"\n");
//			}
//			else pq.offer(op);
//		}
//		System.out.print(sb.toString());
//	}

	

}

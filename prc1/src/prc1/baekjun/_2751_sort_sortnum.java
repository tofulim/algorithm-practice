package prc1.baekjun;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class _2751_sort_sortnum {
	
	static int [] arr;
	static int [] answer_arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr=new int[n+1];
		answer_arr=new int[arr.length];
		for(int i=1;i<=n;i++) arr[i]=Integer.parseInt(br.readLine());
//		quickSort(0,n-1);
//		mergeSort(0,n-1);
		heapSort(n);
		StringBuilder sb = new StringBuilder();
		
		for(int j=1;j<=n;j++) sb.append(arr[j]+"\n");
		System.out.print(sb.toString());
		
	}
	public static void heapSort(int n) {
		maxHeapBuild(n);
		for(int i=n;i>=1;i--) {
			swap(1,i);
			maxHeapify(1,i-1);
		}
	}
	public static void maxHeapBuild(int n) {
		for(int j=n/2;j>0;j--) {
			maxHeapify(j,n);
		}
	}
	
	public static void maxHeapify(int start, int n) {
		int leftChild=start*2;
		int rightChild=start*2+1;
		int k=-1;
		if(leftChild<=n && arr[leftChild]>arr[start]) {
			k=leftChild;
		}
		else k=start;
		
		if(rightChild<=n &&arr[rightChild]> arr[k]) {
			k=rightChild;
		}
		
		
		if(k!=start) {
			swap(start,k);
			maxHeapify(k,n);
		}
		
		
	}

//	public static void mergeSort(int left, int right) {
//		if(left<right) {
//			int mid=(left+right)/2;
//			mergeSort(left,mid);
//			mergeSort(mid+1,right);
//			merge(left,mid,right);
//		}
//	}
//	public static void merge(int left,int mid,int right) {
//		int i=left;
//		int j=mid+1;
//		int k=left;
//		
//		while(i<=mid && j<=right) {
//			if(arr[i]<arr[j]) {
//				answer_arr[k]=arr[i];
//				k++;
//				i++;
//			}
//			else {
//				answer_arr[k]=arr[j];
//				k++;
//				j++;
//			}
//		}
//		while(i<=mid) answer_arr[k++]=arr[i++];
//		while(j<=right) answer_arr[k++]=arr[j++];
//
//		for(int tmp=left;tmp<=right;tmp++) {
//			arr[tmp]=answer_arr[tmp];
//		}
//	}
//	public static int partition(int left, int right) {
//		int pivot=arr[(left+right)/2];
//		
//		while(left<right) {
//			while(left<right && arr[left]<pivot) left++;
//			while(right>left && arr[right]>pivot ) right--;
//			if(left<right) swap(left,right);
//		}
//		return left;
//	}
//	public static void quickSort(int left, int right) {
//		if(left<right) {
//			int q = partition(left,right);
//			quickSort(left,q-1);
//			quickSort(q+1,right);
//		}
//	}
	public static void swap(int a , int b) {
		int tmp=arr[b];
		arr[b]=arr[a];
		arr[a]=tmp;
	}

}

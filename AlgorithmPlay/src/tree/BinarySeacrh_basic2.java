package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySeacrh_basic2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int[] find;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		find = new int[K];
		for (int i = 0; i < K; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < K; i++) {
			int result = bsearch(0, N, find[i]);
//			if(result == -1) {
//				System.out.print("X");
//			}
//			else {
//				System.out.print("O");
//			}
		}
	}
	
	private static int bsearch(int start, int end, int num) {
		
		if(start >= end) {
			System.out.print("X");
			return -1;
		}
		int mid = (start + end) / 2;
		//왼쪽
		if(arr[mid] > num) {
			//지맘대로네...
			return bsearch(start, mid, num);
			//return bsearch(start, mid-1, num);
			
		}
		//오른쪽
		else if(arr[mid] < num) {
			return bsearch(mid+1, end, num);
		}
		else {
			System.out.print("O");
			return arr[mid];
		}
		
	}
}

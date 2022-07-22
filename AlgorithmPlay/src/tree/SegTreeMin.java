package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10 10
48 -17 31 -8 16 46 29 -34 -6 -25 
5 9
1 7
4 8
2 3
5 10
3 5
6 8
3 6
1 6
2 7
 */
/*
-34
-17
-34
-17
-34
-8
-34
-8
-17
-17
 */
public class SegTreeMin {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int tree[];
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		tree = new int[N*4];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		//Arrays.sort(arr, 1, N+1);
//		for (int i = 1; i <= N; i++) {
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
		init(1, N, 1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(query(1,N,1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
	}
	
	public static int init(int start, int end, int node) {
		//종료조건
		if(start == end) {
//			System.out.println("return node "+node+" val "+ arr[start]);
			return tree[node] = arr[start];
		}
		//재귀구성
		int mid = (start+end)/2;
		int left = init(start, mid, node*2);
		int right = init(mid+1, end, node*2+1);
//		System.out.println("node "+node+" val "+ Math.min(left, right));
		return tree[node] = Math.min(left, right);
	}
	
	public static int query(int start, int end, int node, int left, int right) {
		//종료조건
		if(left > end || right < start)
			return Integer.MAX_VALUE;
		if(left <= start && right >= end) {
			return tree[node];
		}
			
		//재귀구성
		int mid = (start+end)/2;
		int leftVal = query(start, mid, node*2, left, right);
		int rightVal = query(mid+1, end, node*2+1, left, right);
		return Math.min(leftVal, rightVal);
	}
}

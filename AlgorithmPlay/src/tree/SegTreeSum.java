package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegTreeSum {

	static int N,M;
	static int[] tree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		tree = new int[N*4];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int result = query(1,N,1,start,end);
			System.out.println(result);
		}
	}
	private static int query(int start, int end, int node, int left, int right) {
		//종료조건
		if(left > end || right < start)
			return 0;
		if(start >= left && right >= end)
			return tree[node];
		
		//재귀구현
		int mid = (start+end)/2;
		int leftVal = query(start, mid, node*2, left, right);
		int rightVal = query(mid+1, end, node*2+1, left, right);
		return leftVal+rightVal;
		
	}
	private static int init(int start, int end, int node) {
		//종료 조건
		if(start == end)
			return tree[node] = arr[start];
		
		//재귀 구현
		int mid = (start+end)/2;
		int left = init(start, mid, node*2);
		int right = init(mid+1, end, node*2+1);
		return tree[node] = left+right;
		
	}
}

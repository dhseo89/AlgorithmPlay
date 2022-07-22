package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//3~6 left,right -> 4 leaf
public class SegTreeSumUpt {

	static int N,M;
	static long[] tree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		tree = new long[N*4];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1,N,1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(cmd == 1) { //변경
				update(1,N,1,start,end);
			}
			if(cmd == 2) { //query
				System.out.println(query(1,N,1,start,end));
			}
		}
	}
	private static long init(int start, int end, int node) {
		//종료 조건
		if(start == end)
			return tree[node] = arr[start];
		
		//재귀구현
		int mid = (start+end)/2;
		long left = init(start, mid, node*2);
		long right = init(mid+1, end, node*2+1);
		return tree[node] = left+right;
	}
	
	static long update(int start, int end, int node, int idx, int val) {
		//종료 조건
		//찾았거나 못찾았거나 단일값이기때문에
		if(start > idx || end < idx) {
			return tree[node];
		}
		if(start == end) {
			return tree[node] = val;
		}
		
		//재귀구현
		int mid = (start+end)/2;
		long leftVal = update(start, mid, node*2, idx, val);
		long rightVal = update(mid+1, end, node*2+1, idx, val);
		return tree[node] = leftVal+rightVal;
		
	}
	
	static long query(int start, int end, int node, int left, int right) {
		//종료 조건
		if(end < left || start > right)
			return 0;
		//3~6 left right, 4 start,end
		if(start >= left && end <= right) {
			return tree[node];
		}
		//재귀구현
		int mid = (start+end)/2;
		long leftVal = query(start, mid, node*2, left, right);
		long rightVal = query(mid+1, end, node*2+1, left, right);
		return leftVal+rightVal;		
	}
}

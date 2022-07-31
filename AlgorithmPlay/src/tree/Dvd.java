package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 입력
2
8 3
6 3 1
5 4
2 4 3 1
 */

/* 출력
6 4 3
2 4 4 4
 */
public class Dvd {

	static int T,N,M;
	static int[] arr;
	static int[] tree;
	static int[] dat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N+M+1];
			tree = new int[(N+M+1)*4];
			dat = new int[N+1];
			for (int i = 1; i <= N; i++) {
				arr[i+M] = 1;
				dat[i] = i+M;
			}
			init(1,N+M,1);
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				int movie = Integer.parseInt(st.nextToken());
				int pos = dat[movie];
				int result = query(1,N+M,1,1,pos);
				System.out.print(result+" ");
				update(1,N+M,1,pos,0);
				update(1,N+M,1,M-i+1,1); //새로만든것중에서 젤뒤에것부터
				dat[movie] = M+1-i;//dat업데이트
			}
			System.out.println();
		}
	}
	
	static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		int left = init(start,mid,node*2);
		int right = init(mid+1,end,node*2+1);
		return tree[node] = left+right;
	}
	
	static int update(int start, int end, int node, int idx, int val) {
		if(idx > end || idx < start) {
			return tree[node];
		}
		
		if(start == end) {
			return tree[node] = val;
		}
		
		int mid = (start+end)/2;
		int left = update(start,mid,node*2,idx,val);
		int right = update(mid+1,end,node*2+1,idx,val);
		return tree[node] = left+right;
		
	}
	
	static int query(int start, int end, int node, int left, int right) {
		if(start > right || left > end) {
			return 0;
		}
		//4 start end  3 left 6 right
		if(start >= left && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int leftVal = query(start,mid,node*2,left,right);
		int rightVal = query(mid+1,end,node*2+1,left,right);
		return leftVal+rightVal;
	}
}
